# CHAPTER 07

```swift
func sayHello(name: String) -> String {
    let returnVlaue = "\(name)님, 안녕하세요"
    return returnVlaue
}
func sayHello(hi: String) -> String {
    let returnVlaue = "\(hi)님, 안녕하세요"
    return returnVlaue
}
sayHello(name: "hi")
sayHello(hi: "hi")
func printHelloWithoutReturn(name: String) {
    print("\(name)님, 안녕하세요")
}

printHelloWithoutReturn(name: "firewood")
printHelloWithoutReturn(name: "firewood1")

/**
 - 함수 호출시에는 name: 이라는 인자 레이블을 붙혀주어야함.
 - Objective-C에서 인자레이블을 사용하기 때문에 호환성을 위해 Swift에서도 인자레이블을 도입하였다.
 */

func times(x: Int, y: Int) -> Int {
    return (x*y)
}

times(x: 5, y: 10) // 함수명 + 인자레이블 + 인자값
times(x:y:)(5,10) // 함수식별자 + 인자값

func getUserInfo() -> (Int, Character, String) {
    let gender: Character = "M"
    let height = 180
    let name = "꼼꼼한 재은씨"
    return(height, gender, name)
}

var uInfo = getUserInfo()
uInfo.0
uInfo.1
uInfo.2

var assignmentToBindedValiables = (a: 1,b: 2,c: 3)
assignmentToBindedValiables.a
assignmentToBindedValiables.b
assignmentToBindedValiables.c

func getUserInfoAndBindVariables() -> (h: Int, g: Character, n: String) {
    let gender: Character = "M"
    let height = 180
    let name = "꼼꼼한 재은씨"
    return(height, gender, name)
}

var result = getUserInfoAndBindVariables()
result.h
result.g
result.n

typealias StringDictionary<Value> = Dictionary<String, Value>

// The following dictionaries have the same type.
var dictionary1: StringDictionary<Int> = StringDictionary()
var dictionary2: Dictionary<String, Int> = Dictionary()

typealias infoResult = (h: Int, g: Character, n: String)

func getUserInfoWithTypealias() -> infoResult{
    let height = 180
    let gender: Character = "M"
    let name = "꼼꼼한 재은씨"
    
    return (height, gender, name)
}

func localParameterNames(name: String, msg: String) {
    print("\(name)님, \(msg)")
}

func externalParameterNames(to name: String, welcomeMessage msg: String) {
    print("\(name)님, \(msg)")
}

func omitExternalParameterName(_ name: String,_ msg: String){
    print("\(name)님, \(msg)")
}

localParameterNames(name: "홍길동", msg: "안녕하세요")
externalParameterNames(to: "홍길동", welcomeMessage: "안녕하세요")
omitExternalParameterName("홍길동", "안녕하세요")

// 함수 식별자
// localParameterNames(name:msg:)
// externalParameterNames(to:welcomeMessage:)
// omitExternalParameterName(_:_:)

// 가변인자(...)는 갯수를 제한하지 않고 배열로 처리됨.
func avg(score: Int...) -> Double {
    var total = 0
    for r in score {
        total += r
    }
    return (Double(total) / Double(score.count))
}

print(avg(score: 10,20,30,40))

// 매개변수에 기본값 지정
func echo(message: String, baseVriable: Bool = true) {
    if baseVriable == true {
        print("기본값은 true")
    } else {
        print("변경값은 \(baseVriable)")
    }
}

echo(message: "기본값")
echo(message: "기본값 변경", baseVriable: false)

// 파라메터는 상수이다.
func incrementBy(base: Int) -> Int {
//    base += 1
    var base = base
    base += 1
    return base
}


var cnt = 30

func callByValue(value: Int) -> Int{
    var value = value
    value += 1
    return value
}
print(callByValue(value: cnt))
print(cnt)

func callByReference(value: inout Int) -> Int{
    value += 1
    return value
}
print(callByReference(value: &cnt))
print(cnt)

/**
 - 상수와 리터럴은 callByReference 형식으로 값을 전달할 수 없다.
 - 변수만 callByReference 형식으로 값을 전달할 수 있다.
 - 클래스는 예외적으로 inout 키워드를 사용하지 않아도 항상 callByReference 형식으로 값을 전달한다.
 */

do {
    var ccnt = 0 // 지역변수
    do {
        var ccnt = 3
        print(ccnt)
    }
    ccnt += 1
    print(ccnt)
}

var global = 30    // 전역변수

func foo() -> Int{
    global += 1
    return global
}
foo()



/**
 ## 일급객체(First-Class Object)
  - 객체가 런타임에도 생성이 가능해야 한다.
  - 인자값으로 객체를 전달할 수 있어야 한다.
  - 반환값으로 객체를 사용할 수 있어야 한다.
  - 변수나 데이터 구조 안에 저장할 수 있어야 한다.
  - 할당에 사용된 이름과 관계없이 고유한 구별이 가능해야 한다.
 */

/**
 ## 일급함수(Frist-Class Function)의 특성
  - 변수나 상수에 함수를 대입할 수 있음
  - 함수의 반환 타입으로 함수를 사용할 수 있음
  - 함수의 인자값으로 함수를 사용할 수 있음
 */

func foo(base: Int) -> String {
    return "결과 값은 \(base + 1)입니다"
}

let fn = foo
fn(5)
// fn의 함수 타입(Function Types)은 (Int) -> String이다.
let fnFunctionTypes : (Int) -> String = foo


func boo(age: Int, name: String) -> String {
    return "\(name)의 나이는 \(age)세 입니다."
}
func boo(hi: Int, name: String) -> String {
    return "\(name)의 나이는 \(hi)세 입니다."
}
let b1 = boo(age:name:)
let b2: (Int, String) -> String = boo(age:name:)
let b3 = boo(age:name:)
let b4: (Int, String) -> String = boo(age:name:)


func overLoading(age: Int, name: String) -> String {
    return "\(name)의 나이는 \(age)세 입니다."
}
func overLoading(height: Int, nick: String) -> String {
    return "\(nick)의 키는 \(height)입니다."
}
let over1 = overLoading(age:name:)
let over2 = overLoading(height:nick:)

func parenthesesReturnType() -> () {
    print("parentheses")
}
func voidReturnType() -> Void {
    print("Void")
}
let parenthesesFunc : ()->() = parenthesesReturnType
let voidFunc : () -> () = voidReturnType


func desc() -> String {
    return "this is desc()"
}
func pass() -> () -> String{
    return desc
}
let p = pass()
p()   //desc()
let a = pass
a()   //pass()
a()() //desc()

func incresas(param: Int) -> Int {
    return param + 1
}
func broker(base: Int, function fn: (Int) -> Int) -> Int {
    return fn(base)
}
broker(base: 3, function: incresas(param:))



func successThrough() {
    print("연산처리가 성공했습니다.")
}
func failthrough() {
    print("처리 과정에 오류가 발생하였습니다.")
}
func divide(base: Int,
            success sCallBack: ()-> Void,
            fail fCallBack: ()-> Void) -> Int {
    guard base != 0 else {
        fCallBack()
        return 0
    }
    
    defer {
        sCallBack()
    }
    return 100 / base
}
divide(base: 30, success: successThrough, fail: failthrough)

/**
 ## defer 블록
  - defer 블록은 작성된 위치와 순서에 상관없이 함수가 종료되기 직전에 실행된다.
  - defer 블록을 읽기 전에 함수의 실행이 종료될 경우 defer 블록은 실행되지 않는다.
  - 하나의 함수나 메소드 내에서 defer 블록을 여러 번 사용할 수 있다. 이때는 가장 마지막에 작성된 defer 블록부터 역순으로 실행된다.
  - defer 블록을 중첩해서 사용할 수 있다. 이때에는 바깥쪽 defer 블록부터 실행되며 가장 안쪽에 있는 defer블록은 가장 마지막에 실행된다.
 */

func defer1() {
    print("defer_1 시작")
    defer {
        print("defer_1 inside")
    }
    print("defer_1 마지막")
}
defer1()

func defer2(){
    print("defer_2 시작")
    print("defer_2 마지막")
    return
    defer {
        "defer_2 inside"
    }
}
defer2()

func defer3(){
    print("defer_3 시작")
    defer {
        print("defer_3 inside 1")
    }
    defer {
        print("defer_3 inside 2")
    }
    defer {
        print("defer_3 inside 3")
    }
    print("defer_3 마지막")
}
defer3()

func defer4(){
    print("defer_4 시작")
    defer {
        print("defer_4_1 시작")
        defer {
            print("defer_4_2 시작")
            defer {
                print("defer_4_3 시작")
                print("defer_4_3 마지막")
            }
            print("defer_4_2 마지막")
        }
        print("defer_4_1 마지막")
    }
    print("defer_4 마지막")
}
defer4()


// 함수의 중첩
func outer(base: Int) -> String {
    func inner(inc: Int) -> String {
        return "\(inc)를 반환합니다."
    }
    let result = inner(inc: base+1)
    return result
}
outer(base: 3)
// outer함수가 종료되면 inner 함수도 소멸함.

func outer2(param: Int) -> (Int) -> String {
    func inner2(inc: Int) -> String {
        return "\(inc)를 리턴합니다."
    }
    return inner2
}
let fn1 = outer2(param: 3)
let fn2 = fn1(30)  // fn1 == inner2(inc:)
// outer2함수가 종료되어도 inner2 함수는 소멸되지 않음. 참조가 남아있음.

func basic(param: Int) -> (Int)->Int {
    let value = param + 20
    
    func append(add: Int) -> Int {
        return value + add
    }
    return append
}
let result = basic(param: 10)
result(10)
let resul2 = basic(param: 20)
resul2(10)
// basic함수가 종료되어도 append 함수와 value상수는 소멸되지 않음. append함수가 클로저를 갖기 때문.

/**
 ## 클로저란 내부함수와 내부함수에 영향을 미치는 주변환경(문맥:Context)을 모두 포함한 객체이다.
 - 클로저는 두 가지로 이루어진 객체입니다. 하나는 내부 함수이며, 또 다른 하나는 내부 함수가 만들어진 주변환경입니다.
 - 클로저는 외부 함수 내에서 내부 함수를 반환하고, 내부 함수가 외부 함수의 지역 변수나 상수를 참조할 때 만들어집니다.
 */

let result1 = basic(param: 10)
let result2 = basic(param: 5)
// result1에 할당된 클로저 정의
func append1(add: Int) -> Int{
    return 30 + add
}
// result2에 할당된 클로저 정의
func append2(add: Int) -> Int{
    return 25 + add
}

// 내부 함수의 참조가 유지되고 있는 경우 내부함수의 지역변수의 값이 캡쳐(Capture)된다.
// 값의 캡쳐는 문맥에 포함된 변수나 상수의 타입이 기본 자료형이나 구조체 자료형일 때 발생한다.

/**
 ## 클로저의 세가지 경우
 1. 전역 함수 : 이름이 있으며, 주변 환경에서 캡처할 어떤 값도 없는 클로저
 2. 중첩 함수 : 이름이 있으며, 자신을 둘러싼 함수로부터 값을 캠쳐할 수 있는 클로저
 3. 클로저 표현식 : 이름이 없으며 주변환경으로부터 값을 챕쳐할 수 있는 경량 문법으로 작성된 클로저
 */

let f = {()-> Void in
    print("클로저가 실행됩니다")
}
f() // 클로저를 할당 후 실행

({
    ()->() in print("클로저가 실행됩니다.")
})() // 클로저를 직접 실행

let c = { (s1:Int, s2: String)-> Void in
    print("s1: \(s1), s2:\(s2)")
}
c(1, "closure") // 클로저를 할당 후 실행

({
    (s1: Int, s2: String) -> Void in
    print("s1: \(s1), s2:\(s2)")
})(1,"closure") // 클로저를 직접 실행


// 경량문법
// sort(by:) 메서드는 by:에 해당하는 정렬 기준 함수의가 true일때 첫번째 인자값(s1)이 앞으로 옴
var value = [1,9,5,7,3,2]

// 오름차순 정렬
func order(s1: Int, s2: Int) -> Bool {
    if s1 < s2 {
        return true
    } else {
        return false
    }
}
value.sort(by: order)
// 내림 차순 정렬
value.sort(by: {(s1: Int, s2: Int) -> Bool in return s1 > s2})
value

let a = "aa"

// 반환값 생략 가능: 컴파일러는 클로저의 구문을 해석하여 반환값을 찾음(sort메소드의 파라메터가 bool이다.))
// 파라메터 타입 생략 가능 : 컴파일러가 파라메터의 타입을 추론함.
value.sort(by: {s1, s2 in return s1 > s2})

// 파라메터 생략 가능: 파라메터 생략시 입력받은 인자값의 순서대로 $0,$1,$2와 같은 내부 상수로 매칭됨
// in 키워드 생략가능 : 파라메터 생략 시 파라메터와 실행구분의 분리가 필요 없으므로 in 생략가능
value.sort(by: {return $0 > $1})

// return 키워드 생략 가능 : 컴파일러는 클로저의 구문을 해석하여 반환값을 찾음(sort메소드의 파라메터가 bool이다.))
value.sort(by: { $0 > $1 })

// sort(by:) 메서드는 연산자 함수(operator functions)을 사용할 수 있음
value.sort(by: > )

/**
 ## 트레일링 클로저(Trailing Closure)
 */
// 마지막 파라메터의 타입이 함수인 경우 : () 외부에 {} 클로저 작성가능
value.sort(){$0 < $1}
value

// 파라메터의 갯수가 한개이고 그 타입이 함수인경우 : ()마저도 생략가능
value.sort{$0 > $1}
value

func divide(base: Int, success s: ()-> Void) -> Int {
    defer {
        s()
    }
    return 100 / base
}
divide(base: 10, success: { print("연산이 성공했습니다.")})
divide(base: 10) { print("연산이 성공했습니다.") }

func callback(fn: ()->Void) {
    fn()
}

callback {
    print("Closure가 실행되었습니다.")
}

func callback2(fn: ()->Void){
//        let f = fn
//    return f
}


func callback3(fn: ()->Void){
    func innerCallback(){
//                fn()
    }
}

func callback4(fn: @escaping ()->Void) {
    let f = fn
    f()
}
callback4 {
    print("Closure가 실행되었습니다.")
}

func callback5(fn: @escaping ()->Void){
    func innerCallback(){
        fn()
    }
}

/**
 ## @escaping
 - non-escaping 클로저는 호출된 함수내에서 직접 실행을 위해서만 호출 가능하다.
 - 변수나 상수에 대입을 허용하면, 클로저가 호출된 함수 바깥에서 실행될 수 있기 때문이다.
 - 함수 파라메터 타입에 @escaping을 추가하면 해당 클로저가 호출된 함수 바깥에서도 실행될 수 있다.
 - 클로저가 기본적으로 non-escaping인 이유는 컴파일러가 코드를 최적화 하는 과정에서의 성능향상 때문이다. 컴파일러가 메모리 관리상의 지저분한 일들에 관여할 필요가 없다.
 - 클로저를 non-escaping하게 만들면 컴파일러가 해당 클로저에 대한 함수 포인터를 관리 하지 않아도 된다.
 */

/**
 ## @autoclosure
  - 컴파일러가 알아서 클로저를 만듬.
  - 인자값을 {} 형태가 아닌 () 형태로 사용할 수 있음
 */
func condition(stmt: ()-> Bool){
    if stmt() == true {
        print("결과가 참입니다.")
    } else {
        print("결과가 거짓입니다.")
    }
}
condition{4>2}

func condition2(stmt: @autoclosure ()-> Bool){
    if stmt() == true {
        print("결과가 참입니다.")
    } else {
        print("결과가 거짓입니다.")
    }
}
condition2(stmt:(4<2)) //컴파일러가 자동으로 클로저 형태로 감싸줌 => {}
```