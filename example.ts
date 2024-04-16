// 이미 선언된 변수를 사용하거나, 변수 이름을 변경합니다.
var anotherMessage = "Hello, TypeScript!";

// 숫자 타입의 변수 선언
var number = 123;

// 함수 정의 및 반환 타입 명시
function add1(x, y) {
    return x + y;
}

// 클래스 정의 및 타입 명시
var Person = /** @class */ (function () {
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    Person.prototype.greet = function () {
        console.log("Hello, my name is ".concat(this.name, " and I'm ").concat(this.age, " years old."));
    };
    return Person;
}());

// Person 클래스의 인스턴스 생성
var person = new Person("John", 30);
person.greet();