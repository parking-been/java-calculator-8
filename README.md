# java-calculator-precourse

## 🧮 문자열 덧셈 계산기

---

### 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 💻 MVC 패턴 구성 연습

---

https://choo.oopy.io/5f9aa500-2950-4da0-8774-572e95fb30fd

링크를 참고하여 MVC 패턴 구성 연습을 진행해보았다.

### 용어 통일

FullString : 입력받은 문자열 (”//;\n1;2;3”)

Delimiter : 구분자 (,: + new)

CalculationString : 계산 문자열 - 입력받은 문자열의 뒷 부분 (”1;2;3”)

### 이야기

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- FullString 문자열을 전달함.
    - DelimiterPolicy : 커스텀 구분자가 있는지 없는지 확인함. `//` 와 `\n` 존재 여부 및 위치 확인
        - 있을 경우 : Delimiter 커스텀 구분자(;)와 CalculationString계산 문자열(1,2:3) 부분을 분리함
        - 없을 경우 : 그냥 그 자체가 CalculationString계산 문자열 (1,2:3)
    - Tokenizer : 커스텀 구분자를 기준으로 계산에 사용될 정수를 분리함 (1, 2, 3)
    - Numbers : 정수값들을 다 더함
- 결과 출력함.

### 협력 : 요청과 응답

- 누군가 문자열을 StringCalculator에 입력한다.
    - (1) StringCalculator은 DelimiterPolicy로 하여금 커스텀 구분자 여부를 확인후, Delimiter와 Calculation String을 추출할 것을 요청함
    - DelimiterParser가 Delimiter과 Calculation String을 추출함으로써 응답함.
    - (2) StringCalculator은 Tokenizer 에게 Delimiter와 Calcultion String에서 정수를 분리할 것을 요청함.
    - IntegerParser는 정수를 분리함으로써 응답함
    - (3) StringCalculator은 Number에게 분리한 정수를 다 더할 것을 요청함
    - Calculator 은 값을 더함으로써 응답함

### 책임 : 하는것과 아는것

- StringCalculator(문자열 계산기)
    - 하는 것 : DelimiterPolicy와 Tokenizer와 Number에 각각 요청함
    - 아는 것 : 전체 문자열, 구분자, 정수값 (미래에 알게될 내용)
- DelimiterPolicy(구분자 추출기)
    - 하는 것 : Delimiter 과 CalculationString을 분리함 + validation
    - 아는 것 : Delimiter, CalculationString
- Tokenizer(정수 추출기)
    - 하는것 : CalculationString에서 Delimiter을 사용하여 정수를 분리 + validation
    - 아는 것 : Delimiter, CalculationString (전달 받음)
- Number(계산기)
    - 하는 것 : min, max, sum 과 같은 기능
    - 아는 것 : 정수값들

## ✒️ 구현할 기능 목록

---

### 입력 멘트

- ‘덧셈할 문자열을 입력해 주세요.’ 멘트 출력

### 입력값 받기

- 입력값 받기
    - null 의 경우 IllegalArgumentException 발생
- 앞뒤 공백 지우기

### 커스텀 구분자 확인 & 문자열 나누기

- ‘//’ 와 ‘\n’의 위치 파악하기
    - `//` 와`\n` 가 문자열 내에 둘 다 존재하는 경우
        - 사이의 커스텀 구문자 확인
            - 커스텀 구문자가 없을 수 도 있다. (`//\n`) → 이경우에도 정상 진행
            - 커스텀 구분자의 길이가 1이 아닌경우
                - IllegalArgumentException 발생
            - 그 외의 경우 → 정상 진행
        - 기존 커스텀 구문자에 새로운 커스텀 구문자 추가 (,: + (new))
        - ‘\n’ 이후 CalculationString 가져오기 (’1:2:3’)
    - `//` 와 `\n` 중 하나만 존재하는 경우 (커스텀 구분자는 문자이기 때문에 문자열로 생각하지 않는다. 즉, `//` 와 `/n`는 커스텀 구분자가 될 수 없다)
        - IllegalArgumentException 발생
    - `//` 와 `\n` 둘다 존재하지 않는 경우
        - CalculationString은 입력문자열과 같다.

### 각 부분을 숫자로 변환

- 커스텀 문자들을 기준으로 Calculation String 분할하기
- Calculation String 을 순회하며 숫자부분으로 이루어져 있는지 확인하고 → int 로 바꿔주기
    - 이때 빈문자열의 경우 IllegalArgumentException 발생 “하나의 문자열로만 구분하기”
    - 숫자가 아닐 경우 Illegal ArgumentException 발생
    - 0일 경우 양수의 입력값을 넣을 수 있도록 Illegal ArgumentException 발생

### 합산 값 계산

- int로 바꿔진 array를 순회하며 합산 값 계산

### 합산 값 출력

- ‘결과 : ’ + result 형식으로 출력되도록 구현

## 🗃️ 역할별 패키지 분리

---

Application : 프로그램 시작점 역할

### [domain]

DelimiterPolicy : Delimiter와 CalculationString을 분리하는 부분
Tokenizer : CalculationString에서 Delimiter를 사용하여 정수를 분리
Number : Tokenizer에서 분리된 정수 array를 받고 합을 연산하는 부분

### [view]

InputView : 사용자로 부터 입력 받기

OutputView : 결과나 메세지를 사용자에게 출력

### [controller]

StringCalculator : 문자열 계산기 역할 domain의 main 부분

### [exception]

ExceptionMessage : exception에 대한 다양한 예외처리 메세지 문구를 저장하는 부분