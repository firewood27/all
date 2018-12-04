# CHAPTER 04

```swift
//: Playground - noun: a place where people can play
/*
 /*
 반복문
 for in
 while
 repeae while
 
 */
 */
for row in 1...5{
    print(row)
}

for row in 1...9{
    print("2 X \(row)");
}

for year in 1950 ... 2017{
    print("\(year)년도");
}

var i : Int8 = 0

for row in 1..<10{
    i+=1;
}
print(i);

var lang = "swift"
for char in lang.characters{
    print("개별 문자는 \(char) 입니다.");
}

let size = 5
let padChar = "0"
var keyword = "3"

//루프 상수의 생략
for _ in 1...size{
    keyword = padChar + keyword
}
print("\(keyword)")


for i in 1..<10{
    for j in 1..<10{
        print("\(i) X \(j) = \(i*j)")
    }
}

var n = 2
while n < 1000{
    n = n * 2
}
print("n = \(n)")

var m = 1024

repeat {
    m = m * 2
}while m < 1000

print("nn = \(m)")

/**
 조건문
 if
 guard
 switch
 */

var adult = 19
var age = 15

if age < adult {
    print("미성년자")
}
if age < adult {
    print("미성년자")
}else{
    print("성년자")
}

var adult_1 = 19
var age_1 = 21
var gender = "M"

if adult > age {
    if gender == "M" {
        print("남자 미성년자입니다")
    }else {
        print("여자 미성년자입니다")
    }
} else {
    if gender == "M"{
        print("남자 성년자입니다")
    }else{
        print("여자 성년자입니다")
    }
}

if gender == "M"{
    print("남자 입니다.")
} else if gender == "F" {
    print("여자 입니다.")
} else {
    print("남자와 여자 어느 쪽에도 속하지 않습니다.")
}

var browser = "Safari"
var browserName : String

if browser == "IE"{
    browserName = "인터넷 익스플로러"
} else if browser == "FF"{
    browserName = "파이어폭스"
} else if browser == "Chrome" {
    browserName = "크롬"
} else if browser == "Opera"{
    browserName = "오페라"
} else if browser == "Safari" {
    browserName = "사파리"
} else {
    browserName = "알려지지 않은 브라우저"
}

print("사용하고 계신 브라우저는 \(browserName)입니다")



//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"

/**
 guard 구문
 else 구문이 필수 이며 표현식의 결과가 참일때 실행되는 블록은 없음
 실행 흐름을 종료하기 위한 목적으로 사용됨
 */

func divide_1(base: Int){
    let result = 100 / base
    print(result)
}

func divide_2(base: Int){
    guard base != 0 else {
        print("연산할 수 없습니다.")
        return
    }
    let result = 100 / base
    print(result)
}

func divide_3(base: Int) {
    if base == 0 {
        print("연산을 처리할 수 없습니다.")
        return
    }
    let result = 100 / base
    print(result)
}

if UIDevice.current.systemVersion.hasPrefix("9") {
    // ios 9 버전에서 지원하는 구문
} else if UIDevice.current.systemVersion.hasPrefix("8"){
    // ios 8 버전에서 지원하는 구문
} else if UIDevice.current.systemVersion.hasPrefix("7"){
    // ios 7 버전에서 지원하는 구문
} else {
    // 기타 나머지 버전에서 지원하는 구문
}

// * 는 인자값 입력이 모두 끝났음을 선언
if #available(iOS 9, OSX 10.10, watchOS 1, *) {
    // iOS 9용 API 구문 또는 OS X 10.10용 API 구문, watchOS 1용 API 구문
} else {
    // API를 사용하지 못했을 때에 대한 실패 처리
}

/**
  스위프트의 switch문은 하나의 조건이 만족하면 더이상 비교하지 않고 분기문을 종료함
  그래서 break문을 생략할 수 있음
 */

let val = 2

switch val {
    case 1 :
        print("일치한 값은 1입니다")
    case 2 :
        print("일치한 값은 2입니다.")
    case 2 :
        print("일치한 값 2가 더 있습니다.")
    default :
        print("어느 패턴과도 일치하지 않았습니다.")
}




/**
 암시적인 Fall Through
 패턴이 일치하는 case 블록을 실행하는 대신, 그 다음 case 블록으로 실행 흐름을 전달하는 문법 (C계열 언어)
 하지만 스위프트에서는 암시적인 Fall Through를 지원하지 않음. 명시적으로 fallthrought 구문을 사용해햐함
 */

let sampleChar : Character = "A"

switch sampleChar {
    case "a","A":
        print("eee")
    case "A":
        print("글자는 A입니다")
case "A":
    print("B")
    default :
        print("일치하는 글자가 없습니다")
}

/**
 튜플은 집단 자료형으로써 괄호로 묶인 이형 집단 데이터 이다.
 switch 구문에서 튜플 내부의 아이템이 비교 대상과 부분적으로 일치할 경우, 스위프트는 case 구문의 비교 패턴 전체가 일치하는 것으로 간주합니다.
 이때 일치하지 않는 나머지 부분을 상수나 변수화 하여 사용할 수 있다.
 */
var value = (2,3)

switch value {
//    case let (x, 3) :
//        print("튜플의 두 번째 값이 3일 때 첫 번째 값은 \(x) 입니다.")
    case let (3, y) :
        print("튜플의 첫 번째 값이 3일 때 첫 번째 값은 \(y) 입니다.")
    case let (x, y) :
        print("튜플의 값은 각각 \(x), \(y)입니다.")
    default :
        print("일치하는 글자가 없습니다")
}


/**
 Array'
 Set
 Tuple
 Dictonary
 */


//: Playground - noun: a place where people can play


/**
 범위 연산자 사용가능
 */
var passtime = 1957

switch passtime {
    case 0..<60 :
        print("방금 작성된 글입니다")
    case 60..<3600:
        print("조금 전 작성된 글입니다")
    case 3600..<86400 :
        print("얼마 전 작성된 글 입니다.")
    default :
        print("예전에 작성된 글입니다.")
}

var value = (2,3)

switch value {
case (0..<2, 3) :
    print("범위 A에 포함되었습니다.")
case (2..<5, 0..<3) :
    print("범위 B에 포함되었습니다.")
case(2..<5, 3..<5) :
    print("범위 C에 포함되었습니다.")
default :
    print("범위 D에 포함되었습니다.")
}

/**
 where 구문을 사용하여 좌표축을 문장으로 표현해 주는 예
 */

var point = (3,-3)

switch point {
case let (x,y) where x == y:
    print("\(x)과 \(y)은 x==y 선 상에 있습니다")
case let(x, y) where x == -y:
    print("\(x)과 \(y)은 x==-y 선 상에 있습니다")
case let(x,y):
    print("\(x)과 \(y)은 일반 좌표상에 있습니다")
}

for row in 0...5{
    if row > 2{
        break
    }
    print("\(row) was executed!")
}

for row in 0...5 {
    if row < 2 {
        continue
    }
    print("executed data is \(row)")
    
    
    
    
    
    
    
    
}

var text = "This is a swift book for Apple's programming language"
var result = ""

for char in text.characters {
    if char == " " {
        result.append(Character("_"))
        continue
    } else if char == "o" {
        result.append(Character("O"))
        continue
    }
    result.append(char)
}
print(result)

/**
 구문 레이블과 break, continue
 */

for i in 1...5{
    for j in 1...9{
        if j==3 {
            break
        }
        print("\(i)X\(j)=\(i*j)")
    }
}
print("-----------------------")


var loopFlag = true

for i in 1...5{
    for j in 1...9{
        if j == 3 {
            loopFlag = false
            break;
        }
        print("\(i)X\(j)=\(i*j)")
    }
    if loopFlag == false{
        break;
    }
}
print("-----------------------")


outer : for i in 1...5{
    inner : for j in 1...9{
        if j == 3 {
            break outer
        }
        print("\(i)X\(j)=\(i*j)")
    }
}
/**
 set
 array
 tuple
 dictionary
 */
```