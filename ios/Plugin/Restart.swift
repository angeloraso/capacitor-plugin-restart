import Foundation

@objc public class Restart: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
