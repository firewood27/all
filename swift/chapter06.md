# CHAPTER 06

```swift

/**
 ## 옵셔널 타입
  - 옵셔널 타입이란 nil을 사용할 수 있는 타입을 말한다.
  - nil은 (값이 없음)을 의미한다.
  - 일반 타입에는 nil을 대입할 수 없음
 */

// Int 객체의 생성자 옵션으로 Optional int값 생성
let num = Int("123")
let num2 = Int("Swift") // 옵셔널 값을 변수나 상수에 할당 받을 수 있음
// 자바 NumberFormatException()
// 자바스크립트 NaN
// 스위프트 nil
print(num) // Optional(123)






/**
 옵셔널 타입 선언과 정의
 */

var optInt : Int?
var optStr : String?
var optDouble : Double?

var optArr : [String]?
var optDic : Dictionary<String, String>?
var optDic2 : [String:String]?
var optClass : AnyObject?


// 옵셔널 타입의 변수에 값을 할당하면 옵셔널 객체 내부에 값이 바로 대입됨
var optInt2 : Int?
optInt2 = 3
var optStr2: String?
optStr2 = "Swiift"
var ooptArr: [String]?
ooptArr = ["C","JAVA","Objective-C","SmallTalk"]
var optDic3: [String : Int]?
optDic3 = ["국어" : 94, "수학" : 88, "영어" : 96]


var optSet : Set<String>?
optSet = Set<String>()
optSet = ["C","B","A"] // 대입연산자는 객체 내부에 값을 바로 할당시킴
print(optSet)
// set의 메소드를 사용하기 위해서는 옵셔널 객체 내부에 접근해야함
optSet!.insert("item")
print(optSet)





/**
 ## 옵셔널 타입을 해제(Optional Unwrapping)하는 4가지 방식
  - 명시적 해제
   - 강제 해제(Forced Unwrapping)
   - 비강제 해제(Optional Binding)
  - 묵시적 해제
   - 컴파일러에 의한 자동해제
   - !연산자를 사용한 자동해제
 */

/**
 ### 강제 해제(Forced Unrwapping)
  - '!' 강제 해제 연산자(Forced-unwrapping Operator) 연산자를 이용하여 강제 해제 하는 방식
 */

var optint: Int? = 3
print("옵셔널 자체의 값: \(optint)")
print("!로 강제 해제한 값: \(optint!)")

var str = "123"
var intFromStr = Int(str)


// 옵셔널 값이 nil이 아닐때만 !연산자를 사용할 수 있도록 if문을 사용
if intFromStr != nil {
    print("값이 변환되었습니다. 변환된 값은 \(intFromStr!)입니다.")
} else {
    print("값 변환에 실패하였습니다.")
}


var str2 = "Swift"
var intFromStr_2 = Int(str2)

if intFromStr_2 != nil {
    print("값이 변환되었습니다. 변환된 값은 \(intFromStr_2!)입니다.")
} else {
    print("값 변환에 실패하였습니다.")
}



/**
 ### 비강제 해제 ==> Optional Binding이라고 한다.
  - 조건문 내에서 일반 상수에 옵셔널 값을 대입하는 방식
 */

print("---------비 강제 해제----------------")

var optBindingStr = "swift"

if var intFromStr = Int(optBindingStr) { // nil이 아닐경우
    print("값이 변환되었습니다. 변환된 값은 \(intFromStr) 입니다.")
} else { // nil일 경우
    print("값 변환에 실패하였습니다.")
}

func intStr(str: String){
    // 매개변수 str이 nil이라면 함수를 탈출한다.
    guard let intFromStr = Int(str) else {
        print("값 변환에 실패하였습니다.")
        return
    }
}

var capital = ["KR" : "Seoul", "EN" : "London", "FR" : "Paris"]
print(capital["KR"])
print(capital["KR"]!)

// if문 검사를 통한 강제 해제
if (capital["KR"] != nil) {
    print(capital["KR"]!)
}

// 비강제 해제
if let val = capital["KR"] {
    print(val)
}

var opInt : Int?
opInt = 123
print(opInt)

print(opInt!) // 강제 해제(Forced UnWrapping)
var b = opInt // 비 강제 해제(옵셔널 바인딩)


/**
 컴파일러에 의한 옵셔널 자동 해제
 - 컴파일러에서 옵셔널을 자동을 해제해 줌.
 - 비교 연산을 수행할 때 한쪽에는 옵셔널 다른한쪽에는 일반타입이라면,
 자동으로 옵셔널을 해제해여 비교연산을 수행함
 */

print("---------컴파일러에 의한 옵셔널 자동 해제----------------")
let cOpt = Int("123")

if (cOpt!) == 123 {
    print("cOpt == 123")
} else {
    print("cOpt != 123")
}

if cOpt == 123 {
    print("cOpt == 123")
} else {
    print("cOpt != 123")
}

var value01 = Optional(123) // 정석적인 옵셔널 타입의 대입
var value02 : Int? = 123
// 컴파일러가 옵셔널 타입에 123을 대입한다는 것을인지하고 123을 Optional(123)으로 변환후 대입


/**
  !연산자를 이용한 자동해제, 옵셔널의 묵시적 해제, 묵시적 옵셔널
  - 옵셔널 타입이긴 하지만 값을 사용할 때는 자동으로 옵셔널 값이 해제됨.
  - 형식상 옵셔널로 정의해야 하지만 실제로 사용할때는 절대 nil값이 대입될 가능성이 없는 변수일 때 사용.
  - 클래스나 구조체에서 유용하게 사용됨
 */
print("---------!연산자를 이용한 자동해제----------------")

// 명시적 옵셔널 선언
var str : String? = "Swift Optional"
print(str!)
// 묵시적 옵셔널 선언
var str2 : String! = "Swift optional"
print(str2) // 컴파일러에 의해 옵셔널 객체가 자동으로 해제됨.

// 명시적 옵셔널에서의 연산
var value1: Int? = 10
print(value1! + 5)
// 묵시적 옵셔널에서의 연산
var value2: Int! = 10
print(value2 + 5)



```