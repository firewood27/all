# CHAPTER 10

```swift

/**
 ## 프로토콜(Protocol)
  - 프로토콜은 Objective-C에서 쓰였던 개념으로 구현체가 어떤 목적을 달성하기 위해 구현해야하는 메소드와 프로퍼티의 목록이다.
  - 프로토콜을 구현할 수 있는 구현체는 구조체, 클래스, 열거형, 익스텐션이다.
 */

// 프로토콜 프로퍼티는 연산 프로퍼티인지 저장 프로퍼티인지 구분하지 않는다.
// 다만 읽기 전용인지, 읽고 쓰기가 가능한지에 대해서만 정의한다.
protocol SomeProtocol{
    var name: String { get set}
    var description: String { get }
    
    // mutating 키워드는 구조체나 열거형의 구현체에서 프로퍼티를 변경할 수 있도록 한다.
    mutating func changeName(name: String)
    func execute(cmd: String)
    func showPort(port: Int) -> String
}

struct RubyMember: SomeProtocol {
    var name = "홍길동"
    var description: String {
        return "Name : \(self.name)"
    }
    
    mutating func changeName(name: String) {
        self.name = name
    }
    func execute(cmd command: String) {
        if command == "start" {
            print("실행합니다.")
        }
    }
    func showPort(port p: Int) -> String {
        return "Port : \(p)"
    }
}
var r = RubyMember()
r.name
r.description
r.execute(cmd: "start")
r.showPort(port: 1)
r.changeName(name: "루비")
r.name

// 프로토콜의 타입 메소드와 프로퍼티
protocol SomeTypeProperty {
    static var defaultValue: String {get set}
    static func getDefaultValue() -> String
}
struct TypeStruct: SomeTypeProperty {
    static var defaultValue = "default"
    
    static func getDefaultValue() -> String {
        return defaultValue
    }
}
class valueObject: SomeTypeProperty {
    static var defaultValue = "defalut"
    class func getDefaultValue() -> String {
        return defaultValue
    }
}

// 프로토콜의 초기화 메소드
// 클래스에서 초기화 메소드를 구현할 때는 required 키워드를 붙여야 한다.
// https://docs.swift.org/swift-book/LanguageGuide/Initialization.html
protocol SomeInitProtocol {
    init()
    init(cmd: String)
}

struct SInit: SomeInitProtocol {
    var cmd: String
    
    init(){
        self.cmd = "start"
    }
    
    init(cmd: String) {
        self.cmd = cmd
    }
}

class CInt: SomeInitProtocol {
    var cmd: String
    
    required init() {
        self.cmd = "start"
    }
    
    required init(cmd: String) {
        self.cmd = cmd
    }
}

// 부모 클래스와 프로토콜 양쪽에서 같은 메소드가 정의되어 있을 때, 해당 메소드를 정의해주고 override를 붙혀주면된다.
protocol Init {
    init()
    func getValue()
}
class Parent {
    init() {}
    func getValue() {}
}
class Child: Parent, Init{
    override required init(){}
    override func getValue() {}
}

/**
 ## 프로토콜을 타입으로 사용
 */
protocol Wheel {
    func spin()
    func hold()
}

class Bicycle: Wheel {
    var moveState = false
    
    func spin() {
        self.pedal()
    }
    
    func hold() {
        self.pullBread()
    }
    
    func pedal() {
        self.moveState = true
    }
    
    func pullBread() {
        self.moveState = false
    }
}

// 타입은 Wheel이지만, 인스턴트는 Bicycle이다.
let trans: Wheel = Bicycle()
trans.spin()
trans.hold()

/**
 ## 델리게이션(Delegation)과 델리게이션 패턴(Delegation pattern)
  - https://en.wikipedia.org/wiki/Delegation_pattern
  - 구성하는 객체는 구성된 객체의 메소드를 실행만 한다.
  - 구성하는 객체는 메소드의 구현을 직접하지 않고 구성된 객체를 호출하는 객체에게 위임한다.
  - IOS앱이 동작하는 방식 대다수가 델리게이트 패턴으로 이루어져 있다.
 */

protocol FuelPumpDelegate {
    func lackFuel()
    func fullFuel()
}

class FuelPump {
    var maxGage: Double = 100.0
    var delegate: FuelPumpDelegate? = nil
    
    // 델리게이션의 호출 시점을 옵저버 프로퍼티가 처리한다.
    var fuelGage: Double {
        didSet {
            if oldValue < 10 {
                // 연료가 부족해지면 델리게이트의 lackFule 메소드를 호출한다.
                self.delegate?.lackFuel()
                print("lack: \(oldValue)")
            } else if oldValue == self.maxGage{
                // 연료가 가득 차면 델리게이트의 fullFuel 메소드를 호출한다.
                self.delegate?.fullFuel()
                print("full: \(oldValue)")
            }
        }
    }
    
    init(_ fuelGage: Double = 0) {
        self.fuelGage = fuelGage
    }
    
    // 연료펌프를 가동한다.
    func startPump() {
        while (true) {
            if (self.fuelGage > 0) {
                self.jetFuel()
            } else {
                break
            }
        }
    }
    
    // 연료를 엔진에 분사한다. 분사할 때마다 연료게이지의 눈금은 내려간다.
    func jetFuel(){
        self.fuelGage -= 1
    }
}
//var pump = FuelPump.init(20)
//pump.startPump()

// Car 클래스에서 델리게이션 구현
class Car: FuelPumpDelegate {
    var fuelPump = FuelPump.init(20)
    init() {
        self.fuelPump.delegate = self
    }
    
    func lackFuel() {
        // 연료를 보충한다.
        print("연료 부족")
    }
    
    func fullFuel() {
        // 연료 보충을 중단한다.
    }
    
    // 자동차에 시동을 겁니다.
    func start() {
        fuelPump.startPump()
    }
}
//var car = Car()
//car.start()

/**
 ## Extension과 Protocol
  - 익스텐션에서 프로토콜을 구현할 수 있다.
 */
class Man {
    var name: String?
    
    init(_ name: String = "홍길동") {
        self.name = name
    }
}

protocol Job {
    func doWork()
}

// Man 클래스는 Job 프로토콜을 구현한 것으로 처리된다.
extension Man: Job {
    func doWork() {
        print("\(self.name!)님이 일을 합니다.")
    }
}
let man = Man()
man.doWork()

/**
 ## 프로토콜의 상속
 - 프로토콜은 프로퍼티, 메소드, 초기화 메소드를 상속 시킬 수 있다.
 - 프로토콜은 다중 상속이 가능하다.
 */

protocol A {
    func doA()
}

protocol B {
    func doB()
}

// C는 A와 B를 상속받음
protocol C: A, B {
    func doC()
    func doA() // 부모의 선언과 자식의 선언이 겹쳐도 아무런 상관이 없다.
}

class ABC: C {
    func doA() {}
    func doB() {}
    func doC() {}
    func doABC() {}
}

let abc: ABC = ABC()
abc.doA()
abc.doB()
abc.doC()
abc.doABC()
let c: C = ABC()
c.doA()
c.doB()
c.doC()
let a: A = ABC()
a.doA()
let ab: A&B = ABC()
ab.doA()
ab.doB()
let abc2 : A&B&C = ABC()
abc2.doA()
abc2.doB()
abc.doC()

// 다형성 적용
func fooA(_ a:A&B) {}
//fooA(a)
fooA(ab)
fooA(c)
fooA(abc)
fooA(abc2)
func fooC(_ c: C){}
//fooA(a)
//fooC(ab)
fooC(c)
fooC(abc)
fooC(abc2)

abc is C
abc is A & B
abc is A
abc is B
a is C
a is B
ab is C
abc2 is A & B & C

// Type Casting
if let aa = a as? ABC {
    aa.doABC()
}

if let abab = ab as? ABC {
    abab.doABC()
}

/**
 ## 클래스 전용 프로토콜(Class Only Protocol)
  - class 키워드를 사용하여 프로토콜의 구현을 클래스할 수 있도록 제한할 수있다.
 */

protocol ClassOnlyProtocol: class, A, B {
}

class OnlyClass: ClassOnlyProtocol {
    func doA() {}
    func doB() {}
}

//struct doStruc: ClassOnlyProtocol {}


/**
 ## 프로토콜의 선택적 요청(Optional Requirement)
  - Optional 키워드를 사용하면 프로토콜에서 선언된 요소들은 필수적으로 구현해야하지만 이를 선택사항으로 바꾸어준다.
  - Optional 키워드 사용의 제약사항
    1. 프로토콜 앞에 @objc를 표시해야 한다. @objc는 파운데이션 프레임 워크에서 정의된 어노테이션이다. 이 어노테이션을 사용하면 코드나 객체를 objective-C 코드에서도 참조할 수 있게 된다.
    2. @objc 어노테이션이 붙은 프로토콜은 구조체나 열거형에서는 구현할 수 없고 오로지 클래스에서만 이 프로토콜을 구현할 수 있다. 그래서 optional 키워드가 붙은 프로토콜은 클래스 전용이 된다.
 */

import Foundation

@objc
protocol MsgDelegate {
    // 메소드 자체가 옵셔널이된다. 이 메소드를 호출할 때는 옵셔널 체인의 계념이 적용되므로 메소드명 뒤에 ?나 !를 붙혀준다.
    @objc optional func onReceive(new: Int)
}

class MsgCenter {
    var delegate: MsgDelegate?
    
    func msgCheck() {
        self.delegate?.onReceive?(new: 1)
    }
}

class Phone: MsgDelegate {
    let msgCenter = MsgCenter()
    init() {
        self.msgCenter.delegate = self
    }
    func alarm (){
        self.msgCenter.msgCheck()
    }
    func onReceive(new: Int) {
        print("\(new) 건의 메시지가 도착했습니다.")
    }
}
let phone = Phone()
phone.alarm()

```









 


