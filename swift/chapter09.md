# CHAPTER 09

```swift

/**
 ## 열거형
 - 열거형은 문자열이나 정수값 등 직접 입력받아야 할 정보들을 입력 대신 '선택'할 수 있도록 만들어 줌으로써 값의 범위를 제한하고, 무작위로 값이 입력되는 것을 방지하여 코드의 안정성을 높여주는 역할을 한다.
 */

/**
 ## 익스텐션
  - 익스텐션은 기존에 작성된 객체를 직접 수정하지 않고도 기능을 추가하는 방법을 제공한다.
 */

/**
 ## 열거형(Enumeration)
  - 열거형의 데이터 멤버들을 '정의(Definition)' 개념으로 작성되는 것이므로 타입으로 사용할 수 있을 뿐만 아니라 컴퍼일러가 미리 인지할 수도 있다.
  - 컴파일러가 미리 인지할 수 있고 없고의 차이는 런타임(Run-Time) 오류와 컴파일(Compile)오류의 차이로 나타난다.
  - 열거형을 사용하면 컴파일러가 오류를 찾아주므로 잘못된 점을 바로 확인하여 수정할 수 있지만, 집단 자료형을 사용하여 데이터 타입을 사용하면 잘못 사용했더라도 실행된 다음에야 오류를 발견할 수 있다.
  - 컴파일 오류보다 런타임 오류를 잡아내기가 훨씬 더 어렵다.
  - 열거형 사용이 권장되는 경우
    1. 원치 않는 값이 잘못 입력되는 것을 막고 싶을 때
    2. 입력받을 값을 미리 특정할 수 있을 때
    3. 제한된 값 중에서만 선택할 수 있도록 강제하고 싶을 때
  - 열거형의 멤버로 정의할 수 있는 데이터 집합은 연속된 값들이 아닌 불연속된 값들의 집합이어야 하며(이런 값을 수학에서는 이산 집합이라고 합니다.) 공통주제에 연관되는 값들로 이루어져 있어야 합니다.
  - 종류가 무한히 늘어나지 않고 몇 가지로 수렴되는 값들이어야하 합니다.
 */

/**
 ## case 키워드
  - enum 키워드의 중괄호 블록 내에는 데이터 멤버들이 case 키워드와 함께 정의된다.
  - 보통은 각 멤버마다 case 키워드와 함께 정의하지만, 멤버가 많을 때는 편의상 한꺼번에 지원하는 방식도 지원한다.
 */

enum Direction {
    case north
    case south
    case east, west
}

let N = Direction.north
let S = Direction.south
let E = Direction.east
let W = Direction.west


/**
  변수나 상수를 특정 열거형 타입으로 선언하면 이 변수에 대입될 수 있는 값은 같은 열거형 타입에 정의된 다른 멤버 값이다.
 */
// 타입 어노테이션 생략  ==> 컴파일러가 타입을 추론함
var directionToHead = Direction.west

// 타입 어노테이션 명시
var directionToHead2 : Direction = Direction.west

//var direction1 = .east //에러
var direction2 : Direction = .east

/**
 ## 열거형 타입을 생략할 수 있을 때와 생략할 수 없을 때
  - 열거형 타입으로 정의된 변수에는 열거형 타입명을 생략하고 멤버 값만 대입해도 오류가 발생하지 않는다.
  - 변수나 상수의 타입 어노테이션을 명시한 경우, 처음부터 타입명을 생략하고 멤버값만 대입해도 오류가 발생하지 않는다.
  - 타입 어노테이션 없이 변수나 상수를 초기화 할 때 타입명은 생략할 수 없다.
 */


/**
 ## 열거형
  - enum 키워드의 중괄호 블록 내에는 데이터 멤버들이 case 키워드와 함께 정의된다.
 */
enum Direction {
    case north
    case south
    case east, west
}
Direction.north.hashValue
Direction.south.hashValue
Direction.east.hashValue
Direction.west.hashValue

var d1 = Direction.west
d1 = .east
var d2 : Direction = .north

switch d1 {
    case Direction.north:
        print("북쪽입니다.")
    case Direction.south:
        print("남쪽입니다.")
    case .east:
        print("동쪽입니다.")
    case .west:
        print("서쪽입니다.")
    default:
        print("열거형의 모든 멤버가 switch구문에 존재하는 경우 default는 생략가능합니다.")
}

// 스위프트에서는 열거형의 멤버에 값을 할당(raw 타입 할당)할 수 있다.
enum Rank:Int {
    case one = 10
    case two = 20
    case three, four, five
}
Rank.one.rawValue
Rank.two.rawValue
Rank.three.rawValue
Rank.four.rawValue
Rank.five.rawValue

//열거형은 내부에 연산 프로퍼티와 메소드를 정의할 수 있다.
enum HTTPCode: Int {
    case OK = 200 // 정상적인 응답
    case NOT_MODIFY = 304 // 캐싱된 데이터 전송
    case INCORRECT_PAGE = 404 // 존재하지 않는 URL 또는 페이지 없음
    case SERVER_ERROR = 500 // 서버 에러
    
    var value: String {
        return "HTTPCode number is \(self.rawValue)"
    }
    
    func getDescription() -> String {
        switch self {
        case .OK:
            return "응답이 성공했습니다. HTTP 코드는 \(self.rawValue) 입니다."
        case .NOT_MODIFY:
            return "변경된 내역이 없습니다. HTTP 코드는 \(self.rawValue) 입니다."
        case .INCORRECT_PAGE:
            return "존재하지 않는 페이지입니다. HTTP 코드는 \(self.rawValue) 입니다."
        default:
            return "서버 오류입니다. HTTP 코드는 \(self.rawValue) 입니다."
        }
    }
    
    static var sValue: String {
        return "static 프로퍼티"
    }
    
    static func getName() -> String {
        return "static 메소드"
    }
}

var response = HTTPCode.OK
response = .NOT_MODIFY
response.value
response.getDescription()
HTTPCode.getName()
HTTPCode.sValue


/**
 ## 연관값(Associated Values)
  - 열거형 객체의 범버와 값은 선언하는 시점에서 정의되지만, 사용하는 시점에서 멈버에 보조값을 설정할 수 있다.
  - 하나의 열거형 멤버 선언으로 여러개의 멤버를 선언한 효과를 낼 수 있다.
  - 연관값은 세부적으로 구분하기 위한 용도 이외에도 실행 시점에서 값을 저장해야할 필요가 있을 때 자주 쓰인다.
  - 열거형에 Raw 타입을 할당하면 연관값을 사용할 수 없다.
 */
enum ImageFormat {
    case JPEG
    case PNG(Bool) // 배경이 투명한가
    case GIF(Int, Bool) //사용된 컬러수, 애니메이션 여부
}

var newImage = ImageFormat.GIF(10, true)
switch newImage {
    case ImageFormat.JPEG:
        print("JPEG 입니다.")
    case ImageFormat.PNG(true):
        print("배경이 투명한 PNG 입니다.")
    case ImageFormat.PNG(false):
        print("배경이 투명하지 않은 PNG 입니다.")
    case ImageFormat.GIF(let numberOfColor, true):
        print("\(numberOfColor)개의 컬러를 사용하고 애니메이션이 적용되었습니다.")
    default:
        print("검색되지 않은 image 입니다.")
}

/**
 ## 익스텐션(Extensions)
 - 익스텐션은 클래스나 구조체, 열거형 등의 기존 객체에 새로운 기능을 추가하여 확장해주는 구문이다.
 - 익스텐션을 통해 구현할 수 있는 것
   1. 새로운 연산 프로퍼티를 추가할 수 있다.
   2. 새로운 메소드를 정의할 수 있다.
   3. 새로운 초기화 구문을 추가할 수 있다.
   4. 기존 객체를 수정하지 않고 프로토콜을 구현할 수 있다.
 */

// 숫자 사이에 언더바를 넣을 경우, 언더바를 사용하지 않고 표기한 것과 아무런 차이가 없다.
// 단지 자릿수를 구분해 주기 위해 넣은 것이다.
1_000 == 1000
1_00_0 == 100_0
1_0_0_0 == 1000
10_00 == 100_0

extension Double {
    var km: Double { return self * 1_000.0 }
    var m: Double { return self }
    var cm: Double { return self / 100.0 }
    var mm: Double { return self / 1_000.0 }
    var description : String {
        return "\(self)km는 \(self.km)m, \(self)cm는 \(self.cm)m, \(self)mm는 \(self.mm)m입니다."
    }
}

2.m
2.km
5.5.cm
125.mm
7.0.description

let distance = 42.0.km + 195.m
print("마라톤의 총 거리는 \(distance)m 입니다.")

extension Int {
    func repeatRun(task: () -> Void) {
        for _ in 0 ..< self {
            task()
        }
    }
}
let d = 3
d.repeatRun {
    print("반갑습니다.")
}

// 구조체나 열거형에서는 자기 자신의 인스턴스를 수정할 때 mutating 키워드를 사용했다.
// 구조체나 열거형을 확장한 경우, 자신의 인스턴스를 수정할 때도 mutating 키워드를 사용한다.
extension Int {
    mutating func square() {
        self = self * self
    }
}
var value = 3
value.square()


/**
 - 클래스의 초기화 구문을 extension할 경우에는 convenience 키워드를 붙혀줘야 한다.
 - https://docs.swift.org/swift-book/LanguageGuide/Extensions.html
 - https://docs.swift.org/swift-book/LanguageGuide/Initialization.html
 */

struct Y {
    var value : Int
    var string : String = ""
    
    init(_ value: Int) {
        self.value = value
    }
}
extension Y {
    init(value: Int, string: String) {
        self.value = value
        self.string = string
    }
}
let y = Y.init(value: 1, string: "1")
y.string
y.value

class X {
    var value : Int
    var string : String = ""
    
    init(_ value: Int) {
        self.value = value
    }
}
extension X {
    convenience init(value: Int, string: String) {
        self.init(value)
        self.string = string
    }
}
let x = X.init(value: 1, string: "1")
x.string
x.value

```