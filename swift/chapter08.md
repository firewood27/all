# CHAPTER 08

```swift
struct Resolution {
    var width = 0
    var height = 0
    
    func desc() -> String {
        return "Resolution 구조체"
    }
}

var insRes = Resolution()
insRes.width = 1920
insRes.height = 1080
insRes.width
insRes.height
insRes.desc()

class VideoMode {
    var interlaced = false
    var frameRate = 0.0
    var name : String? = "abcd"
    var res = Resolution()
    
    func desc() -> String {
        return "VideoMode 클래스"
    }
}

var vMode = VideoMode()
vMode.name = "Sample"
vMode.name
vMode.res.width = 1280
vMode.res.width  // chain


// 구조체에서는 모든 프로퍼티의 값을 인자로 입력받아 초기화 하는 구문을 제공
// 멤버와이즈 초기화 구문(Memberwise Initializer)
let defaultRes = Resolution(width: 1024,height: 768)
defaultRes.width
defaultRes.height



/**
 # 초기화(Initialize)
 - 클래스나 구조체에서 옵셔널 타입으로 선언되지 않은 모든 프로퍼티는 명시적으로 초기화 해주어야 한다.
 - 초기화 방법
 1. 프로퍼티를 선언하면서 동시에 초기값을 지정
 2. 초기화 메소드 내에서 프로퍼티의 초기값을 지정
 */
struct Resolution1_1{
    var width = 0
    var height = 0
    var optLengh : String?
}

struct Resolution2 {
    var width : Int
    var height : Int
    var optLengh : String?
    
    init() {
        self.width = 10
        self.height = 20
    }
}

class VideoMode2 {
    var interlaced = false
    var frameRate = 0.0
    var name : String?
}

class VideoMode3 {
    var interlaced : Bool
    var frameRate : Double
    var name : String?
    
    init() {
        self.interlaced = false
        self.frameRate = 0.0
    }
}


/**
 - 구조체 : 복사에 의한 전달(Call by value)
 - 클래스 : 참조에 의한 전달(Call by Reference)
 */
let hd = Resolution(width: 1920, height: 1080)
var cinema = hd
cinema.width = 2048
hd.width
cinema.width

let video = VideoMode()
video.name = "Original Video Instance"
video.name
let dvd = video
dvd.name = "DVD Video Instance"
video.name
dvd.name


/**
 - 동일 인스턴스인지 비교할 때 : ===
 - 동일 인스턴스가 아닌지 비교할 때 : !==
 */
if (video === dvd) {
    print("video와 dvd는 동일한 VideoMode 인스턴스를 참조하고 있군요.")
} else {
    print("video와 dvd는 서로 다른 VideoMode 인스턴스를 참조하고 있군요.")
}

/**
 # 구조체를 사용하기 좋은 경우.
 1. 서로 연관된 몇 개의 기본 데이터 타입들을 캡슐화하여 묶는 것이 목적일 때
 2. 캡슐화된 데이터에 상속이 필요하지 않을 때
 3. 캡슐화된 데이터를 전달하거나 할당하는 과정에서 참조 방식보다는 값이 복사되는 것이 합리적일 때
 4. 캡슐화된 원본 데이터를 보존해야 할 때.
 # 클래스를 사용하는 경우
 - 위 조건에 해당하지 않는 경우에는 일반적으로 클래스(메모리 낭비가 없으므로)를 사용하는 것이 좋다.
 */













```