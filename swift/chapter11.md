# CHAPTER 11

```swift
import Foundation
/**
 ## 스위프트의 오류 처리 방법(Error Handling, Exception Handling)
  1. 옵셔널
    - 잘못된 처리의 결과나 실행도중 실패 했을때 그 결과로 오류를 발생시키는 대신 nil값으로 반환하여 개발자가 이를 처리하도록 유도하는 개념이다.
    - 스위프트에서의 nil은 값이 없다는 것을 의미한다. (Objective-C 에서의 nil은 객체의 빈 참조를 의미, NULL은 포인터 자료형의 빈 참조를 의미)
    - nil의 처리를 제대로 해주지 않으면 런타임 오류가 발생한다.
    - 함수 외부로 오류를 전달하기 힘들다.
  2. 오류 처리 구문
    - 오류 처리 구문은 반환값 타입이나 코드의 흐름과 상관없이 오류 구문을 던질 수 있도록 하는 구문이다.
    - 스위프트 2.0에서부터 지원한다.
    - 오류를 잡아주지 않으면 런타임 오류가 발생한다.
    - 함수 외부로 오류를 전달하기 쉽다.
 */

let a : Int? = nil
//a!

/**
 ## 오류 발생시키기
   - Error 프로토콜을 구현한 열거형만을 오류타입으로 인정한다.
   - throws키워드를 함수 정의 구문에 추가하여 오류객체가 외부로 나갈 수 있음을 컴파일러에게 미리 알려준다.
   - throws 키워드를 사용한 함수를 호출할 때는 메소드 앞에 try 키워드를 붙혀준다.
   - 오류를 던질 때는 throw 키워드를 사용한다.
 */

// 날짜 형식은 YYYY-MM-DD 이다.
enum DateParseError: Error {
    case overSizeString
    case underSizeString
    case incorrectFormat(part: String) // 연관값(Associated Value)
    case incorrectData(part: String)
}

struct Date {
    var year: Int
    var month: Int
    var date: Int
}

func parseDate(param: NSString) throws -> Date {
    // 입력된 문자열의 길이가 10이 아닐경우 분석이 불가능하므로 오류
    guard param.length == 10 else {
        if param.length > 10 {
            throw DateParseError.overSizeString
        } else {
            throw DateParseError.underSizeString
        }
    }
    
    // 반환할 객체 타입 선언
    var dateResult = Date(year: 0, month: 0, date: 0)
    
    // 연도 정보 분석
    if let year = Int(param.substring(with: NSRange(location: 0, length: 4))) {
        dateResult.year = year
    } else {
        // 연도 분석 오류
        throw DateParseError.incorrectFormat(part: "years")
    }
    
    // 월 정보 분석
    if let month = Int(param.substring(with: NSRange(location: 5, length: 2))) {
        // 월에 대한 값은 1 ~ 12 까지만 가능하므로 그 이외의 범위는 잘못된 값으로 처리한다.
        guard month > 0 && month < 13 else {
            throw DateParseError.incorrectData(part: "month")
        }
        dateResult.month = month
    } else {
        // 월 분석 오류
        throw DateParseError.incorrectFormat(part: "month")
    }
    
    // 일 정보 분석
    if let date = Int(param.substring(with: NSRange(location: 8, length: 2))) {
        // 일에 대한 값은 1 ~ 31까지만 가능하므로 그 이외의 범위는 잘못된 값으로 처리한다.
        guard date > 0 && date < 32 else {
            throw DateParseError.incorrectData(part: "date")
        }
        dateResult.date = date
    } else {
        // 일 분석 오류
        throw DateParseError.incorrectFormat(part: "date")
    }
    
    return dateResult
}

let date = try parseDate(param: "2020-02-31")
date.year
date.month
date.date

/**
 ## 오류 잡아내기
   - do 구문 내에서 try 키워드를 사용하여 오류 발생가능성이 있는 메소드를 호출한다.
   - do 구문 실행 중 오류가 발생하면 catch 구문으로 잡는다.
 */
func getPartsDate(date: NSString, type: String) {
    do {
        let date = try parseDate(param: date)
        
        switch type {
        case "year":
            print("\(date.year)년 입니다.")
        case "month":
            print("\(date.month)월 입니다.")
        case "date":
            print("\(date.date)일 입니다.")
        default:
            print("입력값에 해당하는 날짜 정보가 없습니다.")
        }
    } catch DateParseError.overSizeString {
        print("입력된 문자열이 너무 깁니다. 줄여주세요.")
    } catch DateParseError.underSizeString {
        print("입력된 문자열이 불충분합니다. 늘려주세요.")
    } catch DateParseError.incorrectFormat(let part) {
        print("입력값이 \(part)에 해당하는 값이 잘못되었습니다.")
    } catch DateParseError.incorrectData(let part) {
        print("입력값이 \(part)에 해당하는 값이 잘못사용되었습니다. 확인해주세요.")
    } catch {
        print("알 수 없는 오류가 발생하였습니다.")
    }
}

getPartsDate(date: "2015-12-31", type: "year")
getPartsDate(date: "2015-12-31", type: "month")
getPartsDate(date: "2015-12-31", type: "date")

getPartsDate(date: "2015-13-31", type: "month")
getPartsDate(date: "2015-12-33", type: "month")


/**
 - 오류를 던지도록 설계된 함수나 메소드이지만, 필요에 의해 오류를 던지지 않게 하고 싶을 때는 try!를 쓴다.
 - try! 키워드를 사용하면 오류를 던지지 않고 그대로 함수를 실행한다.
 - try!를 사용한 경우 강제로 함수가 실행되지만 런타임오류로 이어진다.
 */
//let tryError = try parseDate(param: "2020-02-33") // 에러 메시지가 콘솔에 출력되지 않음 런타임 오류로 종료됨
//print("try 에러")
//let tryForceError = try! parseDate(param: "2015-09-33") // 런타임 오류 메시지가 떨어짐
//print("tryForceError")
```