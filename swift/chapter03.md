# CHAPTER 03 

```swift
import UIKit

let frame = CGRect(x: 100, y: 100, width:200, height: 100)
let view = UILabel(frame: frame)

view.backgroundColor = UIColor.red
view.textAlignment = .center
view.text = "Hello, World!!!"

Int.max
Int.min

Int64.max
Int64.min

Int32.max
Int32.min

Int16.max
Int16.min

Int8.max
Int8.min


UInt.max
UInt8.max
UInt16.max
UInt32.max
UInt64.max

var firstletter : Character = "s"

let lastLetter : Character = "t"

var day = 7

var year : Int32

year = 1999

var temper1 = 3
var temper2 : Float = 3


var stringValue = "문자열"
var charValue : Character = "문"

var cValue : Character = "C"
var sValue = "C"

var stmt = "185"
var height : Int = 185

//var heightStmt = Int(stmt) + height


let _name = "꼼꼼한 재은씨"
let _year = 2014
let _month = 10
let _day = 1

let profile = "\(_name)는 \(_year)년 \(_month)월 \(_day)일에 출간되었습니다."
print(profile)

let apple = 3
let banana = 2
let orange = 4

let desc = "과일은 총 \(apple+banana+orange)개 입니다."
print(desc)

let result = "1부터 5까지의 숫자의 합은 \(1+2+3+4+5) 입니다"
print(result)

let Hello = "Hi, I'm winny"
var message = Hello
print(message)

let poem = "계절이 지나가는 하늘에는 \n" +
    "가을로 가득 차 있습니다. \n" +
    "나는 아무 걱정도 없이 가슴 속의 별들을\n" +
    "다 헬 듯 합니다"
print(poem)

let poem_triple = """
    계절이 지나가는 하늘에는
    가을로 가득 차 있습니다
    나는 아무 걱정도 없이 가슴 속의 별들을
    다 헬 듯 합니다
    """
print(poem_triple)

//산술 연산자 테스트
let a = 10
let b = 2

//단항 연산자
-a
-b
// 이항 연산자
a + b
a - b
a * b
a / b
a%b

let aa = 10
let bb = 5
let cc = 2

aa > bb && bb > cc
aa == bb && aa > bb
aa == bb || aa > bb

aa - bb > bb - cc && bb == 0
aa + bb > cc || cc  > 0

//닫힌 범위 연산자(Colsed range operator)
1 ... 5
//반 닫힌 범위 연산자(Half-closed range operator)
1 ..< 5

let x = 1
let y = 5

for row in x...y{
    print(row)
}
for row in x..<y{
    print(row)
}
```
