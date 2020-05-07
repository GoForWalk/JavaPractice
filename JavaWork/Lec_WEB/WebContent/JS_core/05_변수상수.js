// var, let, const

// var를 사용한 변수 선언
var a = 100;
console.log('a=', a)
a = 200
console.log('a=', a)

var a = 500;
console.log('a=', a)

// ES6 부터 let, const 로 변수 상수 지정.
let value = 177; // 변수 value 선언
console.log('value=', value);

value = 555;
console.log('value=', value);

// let value = 999; // 중복 선언 불가! 동일이름 변수 let 으로 선언 불가!! 
// console.log('value=', value);

//상수 선언
const b = 1;
console.log('b=', b)

// b = 2; // 오류


// ---------------------------------------------
// var 는 오늘날 JS 환경에서 권장하지 않음. (사용은 가능하다.)

// var 와 let
// IE9, IE10  와 같은 구형 브라우저에서는
//  let, const 를 사용 못함.

// 개발 단계에서는 '바벨' 등을 사용하여
// 우리가 개발한 코드가 구형 브라우저 에서도 동작케 함.

let c; // 초기화를 따로 해도 가능.
c = 100;

// ` : back tick : JS 에서 유용하게 쓰인다.(파이썬, 코틀린에서도 사용)
console.log(`c=${c}`); // Template Literal (ES6 <= )

// 데이터 타입들

let value2 = 100; // number 타입

console.log(value2, typeof value2); // typeof 연산자: 변수의 타입을 나타난다.

// JS 는 대입되는 값에 따라 '타입' 바뀜. (dynamic type language)
value2 = 'Hello'; // String 타입
console.log(value2, typeof value2);
value2 = "Hello"; // '~', "~" 둘다 가능




