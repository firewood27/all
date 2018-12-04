# CHAPTER 05

```swift
/**
    ## 집단 자료형 Collective Types
     - 배열(Arrary) 일련변호로 구분되는 순서에 따라 데이터가 정렬된 목록 형태의 자료형
     - 집합(Set) 중복되지 않은 유일 데이터들이 모인 집합 형태의 자료형
     - 튜플(Tuple) 종류에 상관없이 데이터들을 모은 자료형, 수정 및 삭제를 할 수 없음
     - 딕셔너리(Dictionary) 배열과 유사하나 일련번호 대신 키를 사용하며 키-값으로 연관된 데이터들이 순서 없이 모인 자료형
     - 앱 개발시에는 추가적으로 파운데이션 프레임워크에서 제공하는 자료형들을 사용할 수 있다. ex) NSString, NSNumber, NSData, NSArray, NSMutableArray
 */

/*
   ## 배열의 특징
    - 배열에 저장할 아이템의 타입에는 제약이 없지만, 하나의 배열에 저장하는 아이템 타임은 모두 같아야함.
    - 선언 시 배열에 저장할 아이템 타입을 명확히 정의해야 함
    - 배열의 크기는 동적으로 확장할 수 있음
 */










// 정적(Static)인 방식으로 배열 선언
var cities = ["Seoul", "New York", "LA", "Santiago"]
cities[0]
cities[1]
cities[2]
cities[3]












let length = cities.count // .count는 속성(properties)이다.
for i in 0..<length {
    print("\(i) 번째 배열 원소는 \(cities[i])")
}

// 루프를 반복할 때마다 cities.count를 계산한다.
for i in 0..<cities.count {
}









// 리터럴(Literal)은 값이 변수나 상수에 담긴 형태가 아니라 값 자체를 말한다.
let size = "180" // size 상수에 180이라는 리터럴을 대입
var size_v = "180" // size_v 변수에 180이라는 리터럴을 대입
print(size) // 상수를 사용
print(size_v) // 변수를 사용
print("180") // 리터럴을 사용









/**
 배열의 순회 탐색(순서가 있는 데이터를 처음부터 마지막까지 차례대로 읽어들이는 것).
 1. 배열의 길이를 직접 다루는 방식.
   => 배열의 길이가 필요함.
 2. 배열의 순회 특성(Iterator)을 이용하는 방식
   => for in 구문에 데이터를 직접 넣음
 */
// 배열의 순회 특성을 사용하여 탐색
for row in cities {
    // 상수에 담기는 값은 현재 인덱스가 아니고 배열 아이템 자체이다.
    print("배열 원소는 \(row)입니다.")
}



for row in cities {
    // 인덱스 값을 찾기 위해서는 배열 객체의 index(of:)를 사용한다.
    let index = cities.index(of: row)
    print("\(index!) 번째 배열 원소는 \(row)입니다.")
}




/*
 ## 배열의 동적 선언과 초기화
  - 선언 : 어떠한 배열을 만들 것을 컴파일러에게 미리 알려주는 것. (메모리 공간을 차지하고 있지 않음)
  - 초기화(initialization) : 해당 배열을 실제 만드는 것. (메모리 공간을 차지함)
  - 배열을 정의하는 구조체 : Array<아이템 타입>()
 */

// 문자열 배열의 선언 및 초기화

// 문자열 배열을 선언
var fruits_2 : Array<String>
//배열의 초기화
fruits_2 = Array<String>()
fruits_2 = Array()



// 선언부와 초기화 구문의 타입어노테이션 명시를 생략없이 모두 적을 경우
var fruits_3 : Array<String> = Array<String>()

// 선언부의 구문에 타입어노테이션 명시를 생략한 경우
// 문자열 형식의 배열 객체를 정의한 다음, fruits 변수에 대입하고 있음
var fruits_1 = Array<String>()




/**
 ## 스위프트에서 배열을 정의하는 두 번째 형식
  - 대괄호 사이에 아이템 타입을 기술하는 방식
  - [아이템 타입]()
  - Array 구조체는 [] 기호로 대체할 수 있음
 */

// 배열 선언과 초기화
var machinery_1 = [String]()

// 배열 선언
var machinery_2 : [String]

//배열 초기화
machinery_2 = [String]()

// 초기화 처럼 보이지만 자세히 보면 빈 배열을 하나 만들어서 변수에 할당하는 것이다.
machinery_2 = []
print(machinery_2)









// 다향한 선언과 초기화 방식 중 각자 익숙한 형태를 골라 사용하면 된다.

var machinery_3 : [String] // 선언
machinery_3 = [String]() // 초기화
var country : [String] // 선언
country = [] //초기화
var list : [Int] = [] // 타입 어노테이션 + 초기화
var row : Array<Float> = [Float]()
var tables : [String] = Array()





/**
 ## 배열이 비어있는지 체크하는 방법
  - 배열의 길이를 체크하는 방법이 있지만 배열 구조체에서 제공하는 속성인 isEmpty를 사용하는것이 좋다.
  - true or false 반환
  - 이 속성은 읽기 전용으로 (Read-Only) 해당 속성을 변경할 수 없다.
 */
var laundry = [String]()

if laundry.isEmpty {
    print("배열이 비어 있는 상태입니다.")
} else {
    print("배열에는 \(list.count)개의 아이템이 저장되어 있습니다.")
}




/**
 ## 배열 아이템을 동적으로 추가하는데 자주 사용하는 대표적인 세가지 메소드
 - append(_:) : 입력된 값을 배열의 맨 뒤에 추가함.
 - insert(_:at:) : 원하는 위치에 직접 추가하고 싶을 때 사용함.
 - append(contentsOf:) : 배열의 맨 마지막에 아이템을 추가하지만, 여러개의 아이템(배열)을 한꺼번에 추가할 때 사용함.
 */

var towns = [String]()
towns.append("Seoul")
towns.append("New York")
towns.insert("Tokyo", at: 1)
towns.append(contentsOf: ["Dubai","Sydney"])
towns.insert(contentsOf: ["ff","aa"], at: 0)
towns[2] = "paris"
towns



var monitors = [String]()
//monitors.insert("Dell 27H", at: 3) // 인덱스 참조 오류
monitors.insert("Dell 24H", at:0) // 마지막 인덱스의 다음인덱스는 참조 허용






// Array(repeating:count:) 구문을 사용하여 인덱스 갯수를 미리 정의 할 수 있음
var metropolises = Array(repeating: "None", count: 3)
var capitals = [String](["aa","bb","cc"])





/**
 ## 범위 연산자를 이용한 인덱스 참조
 */
var alphabet = ["a","b","c","d","e"]
alphabet[0...2] // 범위 연산자를 사용하여 인덱스들을 참조하면 배열로 읽어온다.
alphabet[0...3]
alphabet[1..<3]

// 범위 연산자로 읽어온 배열에 다른 크기의 배열을 할당할 수 있다.
alphabet
alphabet[1...2] = ["1","2","3"]
alphabet
alphabet[2...4] = ["A"]
alphabet

/**
 ## 참고 NSArray, NSMutableArray
  - Array : 스위프트에서 제공, Struct, 한가지 자료형만 처리가능
  - NSArray, NSMutableArray : Foundation FrameWork, Class, 여러 종류의 자료형 처리 가능
 
  - NSArray : 수정이 필요 없는 배열에 사용
  - NSMutableArray : 수정이 필요한 배열에 사용
 */


/**
 # 집합(Sets)
  - 집합은 같은 타입의 서로다른 값을 중복 없이 저장하고자 할 때 사용한다.
  - 집합은 내부적으로 해시(Hash)연산을 사용한다.
  - 해시 연산을 사용하므로 속도가 빠르다. Best case O(1) Worst case : O(n)
  - 해시 테이블을 사용하므로 배열보다 메모리의 크기를 많이 차지한다.
  - 집합에 저장할 데이터 타입은 해시 값을 계산하는 방법을 제공해야한다.
  - 스위프트에서 기본으로 제공하는 모든 타입은 해시 연산을 할 수 있다.
  - 만약 임의로 만든 타입을 사용하여 집합을 사용하고자 한다면, Hashable 프로토콜을 구현해야 한다.
 // https://developer.apple.com/documentation/swift/hashable
 // Hashbale을 구현하는 목적은 임의로 만든 타입의 어떠한 원소를 hash key로 쓸 것인지를 지정해 주는 것 같다.
 */

/**
 ## 집합의 정의
 */
var genres_3 : Set<String> // Set 선언
genres_3 = Set<String>() // Set 초기화







var genres : Set<String> = ["Classsic", "Rock", "Balad"]
var genres_1 : Set = ["Classsic", "Rock", "Balad"]
var genres_2 = Set<String>() // 빈 집합 정의

genres_2.insert("Classic") // insert(_:) 메서드로 아이템 추가.
genres_2.insert("Rock")






if genres.isEmpty {
    print("집합이 비어잇습니다")
} else {
    print("집합에는 현재 \(genres.count) 개의 아이템이 저장되어 있습니다.")
}





/**
 ## 집합의 순회 탐색
 - 배열처럼 인덱스를 활용하여 순회 탐색을 할 수 없음.
 - 순회 속성이 제공되므로 for in 구문에 그대로 넣고 처리하는 방식을 사용
 */
var music : Set = ["Classic", "Rock", "Balad"]
for g in genres {
    print("\(g)")
}
print("----------------------------------------")
// .sorted() 메소드를 사용한 경우, 정렬된 배열을 반환 받음
for g in genres.sorted(){
    print("\(g)")
}

print("----------------------------------------")
/**
 ## 집합의 동적 추가와 삭제
 */
var types : Set = ["Classic", "Rock", "Balad"]
types.insert("Jazz")
types.insert("Rock") // 중복 데이터는 추가되지 않음
types

let removedItem = types.remove("Rock")
removedItem
let removedItem_2 = types.remove("123") // 삭제할 값이 없는 경우 nill 반환

types
types.removeAll() // types 집합의 모든 아이템 삭제
if types.isEmpty {
    print("모든 아이템이 삭제되었습니다.")
} else {
    print("아직 \(types.count)개의 아이템이 남아있습니다.")
}

// contains(_:) 해당 집합내에 일치하는 아이템이 있으면 true, 아니면 false를 반환함
var types_2 : Set = ["Classic", "Rock", "Balad"]
if types_2.contains("Rock"){
    print("Rock 아이템이 저장되어 있습니다.")
} else {
    print("Rock 아이템이 저장되어 있지 않습니다.")
}

/**
 ## 집합연산
 */
var oddDigits : Set = [1,3,5,7,9] // 홀수 집합
let evenDigits : Set = [0,2,4,6,8] // 짝수 집합
let primeDigits : Set = [2,3,5,7] // 소수 집합

oddDigits.intersection(evenDigits).sorted() //교집합
oddDigits.symmetricDifference(primeDigits).sorted() //배타적 합집합, 대칭차
oddDigits.union(evenDigits).sorted() // 합집합
oddDigits.subtract(primeDigits) // 차집합
oddDigits.sorted()

let A : Set = [1,3,5,7,9]
let B : Set = [3,5]
let C : Set = [3,5]
let D : Set = [2,4,6]

B.isSubset(of: A) // B가 A의 부분집합이거나 동일한 집합인가?
A.isSuperset(of: B) // A가 B의 상위집합이거나 동일한 집합인가?
C.isStrictSubset(of: A) // C가 A의 부분 집합인가?
C.isStrictSuperset(of: B) // C가 B의 상위 집합인가?
A.isDisjoint(with: D) // A와 D는 공통 집합이 없는가?

// 배열에서 중복을 제거하려면 배열을 집합으로 바꾸고 다시 배열로 바꾸어 주면 된다.
var array = [4,2,5,1,7,4,9,11,3,5,4] // 배열
let set = Set(array) // 집합
array = Array(set) // 중복이 제거된 배열
array = Array(Set(array)) // 한줄로 처리



/**
 # 튜플
  - 여러가지 타입의 아이템을 저장할 수 있음.
  - 일단 선언되고 나면 최초에 선언된 상태의 아이템만 사용할 수 있고 수정이나 삭제, 추가 등 변경은 할 수 없음.
  - (<튜플 아이템1>, <튜플 아이템2>, ...)
 */

// (String, String, Int, Double, Bool)
let tuplevalue = ("a", "b", 1, 2.5, true)

// 배열에서는 인덱스를 사용하기 위해 대괄호를 사용
// 튜플에서는 인덱스를 사용하기 위해 점(dot)을 사용
tuplevalue.0 // "a"
tuplevalue.1 // "b"
tuplevalue.2 // 1
tuplevalue.3 // 2.5
tuplevalue.4 // true







// 튜플은 별도의 선언 구문이 없음 (초기화를 해주어야 하기 때문에)
// 타입 어노테이션을 사용하여 타입 정의는 할 수 있음
var tpl01 : (Int,Int) = (100, 200)
var tpl02 : (Int,String,Int) = (100, "a", 200)
var tpl03 : (Int, (String, String)) = (100,("t","v")) // 튜플을 중첩하여 사용할 수 있음
tpl03.0 // 100
tpl03.1.0 // "t"
tpl03.1.1 // "v"

// 주의점 : 하나의 아이템만 있는 튜플은 일반 자료형으로 선언된다.
var tpl04 : (String) = ("sample string")
var tpl05 = (123)






// 타입어노테이션을 사용하여 타입을 지정하는 이유 :
// 타입을 지정하지 않으면 타입추론 원칙에 의해 상위 타입으로 추론됨.
let tuple : (String, Character, Int, Float, Bool) = ("a","b",1,2.5,true)

// 튜플의 아이템을 개별 변수나 상수로 각각 할당 받는 (Binding)방식의 구문을 사용할 수 있음
let (a,b,c,d,e) = tuple
a // "a"
b // "b"
c // 1
d // 2.5
e // true
var (f,g,h,i,j) = tuple
f // "a"
g // "b"
h // 1
i // 2.5
j // true

// 바인딩 되는 변수의 갯수는 튜플의 갯수와 일치해야함.
// 원하는 않는 원소는 언더바(_)로 대체할 수 있음.
let (v,_,_,_,x) = tuple
v // "a"
x // true






/**
 ## 튜플은 자료형이라기 보다는 데이터들을 묶어주는 연산자로 보는것이 타당하다는 견해도 있다.
  - 튜플은 선언할 수 있는 키워드가 없다. (선언과 초기화가 동시에 이루어져야 하므로)
  - 제공하는 메소드가 전혀 없다.
  - 튜플의 크기를 계산할 수 있는 특성이 없다
  - 데이터를 읽어올 수 있는 메소드가 없다.
  - 순회 특성(SequenceType)을 지원하지 않아 for ~ in 구문을 사용할 수 없다.
  -
 */

// 보통 둘 이상의 값을 반환하기 위해서는 별도의 객체를 만들거나 배열을 만들어서 반환했다.
// 이때, 튜플로 반환하면 손쉽게 둘 이상의 값을 반환할 수 있다.
func getTupleValue() -> (String, String, Int) {
    return ("t","v",100) // 둘 이상의 값을 반환할 수 있음
}

// 함수가 반환하는 튜플을 튜플 상수로 바인딩
let (first,second,third) = getTupleValue()
first  // "t"
second // "v"
third // "100"

/**
 # 딕셔너리(Dictionary)
  - 고유 키와(Key)와 그에 대응하는 값(Value)을 연결하여 데이터를 저장하는 자료형
  - [키 : 테이터, 키 : 데이터 ...]
  - 하나의 키는 하나의 데이터에만 연결되어야 한다.
  - 만약 키가 중복되면 데이터가 수정된다.
  - 지정할 수 있는 타입은 제한이 없지만, 하나의 딕셔너리의 모든 타입은 일치해야한다.
  - 딕셔너리 아이템에 순서는 없지만 키에는 내부적으로 순서가 있으므로 for~in 구문을 이용한 순회탐색을 할 수 있다.
  - 키 타입에 대한 제한은 거의 없으나 해시(Hash)연산이 가능한 타입이어야 한다. => Hashable 프로토콜이 구현되어 있어야 한다.
  - 딕셔너리도 해시를 이용하여 구현됨
 */

// 딕셔너리의 선언과 값정의
var capital = ["KR" : "Seoul", "EN":"London", "FR" : "Paris"]
capital["KR"]
capital["EN"]
capital["FR"]







// 여러 타입의 선언과 초기화
// Dictinary <키의 타입, 값의 타입>()   <== Dictionary 구조체 사용
// [키로 사용할 타입 : 값으로 사용할 타입]() <== 간결한 형식
var a = Dictionary<String, Int>()
var b = Dictionary<String, String>()
var c = Dictionary<String, AnyObject>()
var d = Dictionary<Character, String>()
var e = [String : Int]();
var f = [String : String]();
var g = [String : AnyObject]();
var h = [Character : String]();




//딕셔너리 선언
var capital_1 : Dictionary<String, String>
// 딕셔너리 초기화
capital_1 = Dictionary()

// 타입어노테이션을 사용한 딕셔너리의 선언
var capital_2 : [String:String]
// 딕셔너리의 초기화
capital_2 = [String:String]()


// 4가지 방식의 딕셔너리 초기화 방법
var capital_3 : [String:String]
capital_3 = Dictionary<String,String>()
capital_3 = Dictionary() // 딕셔너리 타입 지정 생략
capital_3 = [String:String]()
capital_3 = [:] // 딕셔너리 타입 지정 생략

/**
 ## 딕셔너리에 아이템 추가하기
 */

var newCapital = [String:String]()
newCapital["JP"] = "Tokyo"

if newCapital.isEmpty {
    print("딕셔너리가 비어있는 상태입니다.")
} else {
    print("딕셔너리의 크기는 현재 \(newCapital.count)입니다.")
}



/**
 ### 메소드를 사용하여 아이템 추가
  - updateValue(_:forKey:)
  - 저장된 키가 있다면 연결된 값을 변경함
  - 저장된 키가 없다면 새로운 값을 저장함
  - 리턴값은 기존에 저장되어있던 데이터의 optional이다.
 */

let kr = newCapital.updateValue("Seoul", forKey: "KR")
kr // nil (값이 없음)
let en = newCapital.updateValue("London", forKey: "EN")
en // nill (값이 없음)
let jp = newCapital.updateValue("Sapporo", forKey: "JP")
// updateValue로 연결될 값을 변경하거나 새로운 값을 추가할 때,
// 기존의 데이터가 있다면 리턴 타입이 nill이 아니고,
// 기존의 데이터가 없다면 리턴 타입이 nill이기 때문에 반환값은 optional이다.
jp // tokyo

newCapital.updateValue("Otawa", forKey: "CA")
newCapital.updateValue("Beijing", forKey: "CN")
newCapital

/**
 ### 딕셔너리 아이템의 삭제
 - removeValue(forKey:)
 - updateValue와 마찬가지로 반환 값은 optional이다.
 */
newCapital["CN"] = nil
newCapital
let value = newCapital.removeValue(forKey: "CA")
print(value)
if let removedValue = newCapital.removeValue(forKey: "JP"){
    print("삭제된 값은 \(removedValue) 입니다.")
} else {
    print("아무것도 삭제되지 않았습니다.")
}

/*
  딕셔너리 역시 해시 연산을 사용하여 정렬되므로,
  Array에서 사용했던 Array.count 를 이용하여 for ~ in문을 사용할 수 없고,
  딕서너리 객체 자체를 사용하는 for ~ in 문은 사용할 수 있다.
 */

// 딕셔너리의 순회 기능을 사용하여 순회 탐색을 실행한다.
for row in newCapital {
    // 딕셔너리에서 꺼낸 키 - 값 한 쌍이 담긴 row 상수를 튜플로 받는다.
    let (key, value) = row
    print("현재 데이터는 \(key) : \(value)입니다.")
}

for (key, value) in newCapital{
    print("현재 데이터는 \(key) : \(value)입니다.")
}

/**
 ## 정리
 - 배열 : 순서 있는 데이터들을 저장할 때 사용하며 중복된 값을 저장할 수 있다. 저장된 데이터는 인덱스로 관리 된다.
 - 집합 : 순서 없는 데이터를 저장할 때 사용하며, 중복된 값은 한 번만 저장된다.
 - 딕셔너리 : 순서 없는 데이터를 키-값 형태로 저장할 때 사용하며, 중복된 값을 저장할 수 있지만 중복된 키는 사용할 수 없다.
 - 튜플 : 데이터를 나열해서 소괄호로 묶어 사용하며, 내부적으로 순서가 있지만, 순회 처리를 지원하지는 않는다. 서로 다른 타입의 데이터를 저장할 수 있다.
 */



```
