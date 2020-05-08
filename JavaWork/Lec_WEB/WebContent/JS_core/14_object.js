// object
console.log('object');

// property: value 쌍
x = {firstName: "John", lastName: "Doe"};
console.log(x, typeof x);

console.log(x['firstName'], x.firstName, typeof x.firstName);
// console.log(x[firstName]); // err : ReferenceError: firstName is not defined


// object 는 length 값 없다.
console.log(x.length); // undefined

// for ~ in 사용 -> property 추출(String)
for(key in x){ 
    console.log(`x[${key}] = ${x[key]}`);
}

// value 는 어떠한 타입이라도 가능!
x = {
    name : "kim"
    , age : 34
    , height : 172.3
    , score : [94, 35, 79]
    , sayHello : function(){
        console.log('hello');
    }
    ,getScore : function(n){
        return this.score[n];
    }
    ,getTotal : function(){
        var sum = 0;
        for(i = 0; i < this.score.length; i++){
            sum += this.score[i];
        }
        return sum;
    }
    ,getAvg : function(){
        return (this.getTotal()/this.score.length);
    }

};

console.log(x['name'], typeof x['name']);
console.log(x['age'], typeof x['age']);
console.log(x['height'], typeof x['height']);
console.log(x.score, x.score.length);
x.sayHello();
console.log(x.getScore(0)); // err: this 안쓰면 에러!! 
console.log(x.getTotal());  // score 접수 함계
console.log(x.getAvg());   // score 점수 평균

console.log();

// p:v 추가 / 삭제 / 변경

x = {firstName: "John", lastName: "Doe"};
console.log(x);
x.firstName = "Mike" // 변경
console.log(x);

x.age = 43; // 없던 property 추가
console.log(x);

delete x.firstName;
console.log(x);

// 없는 property 접근하려 하면, undefined
console.log(x.firstName);
//--------------------------

// console.log(a);
var b
console.log(b);
b= '김재현'
console.log(b);

// '함수'가 object 생성자로 사용가능.

function Person(firstName, lastName, age){
    // 함수 안에서 this!
    this.firstName = firstName; 
    this.lastName = lastName;
    this.age = age;

    // console.log(this);

}

Person('aaa', 'bbb', 30);

var p1 = new Person('aaa', 'bbb', 30); //생성자
console.log(p1);

var p2 = new Person('김', '재현', 25);
console.log(p2);

console.log(`\n프로그램종료`)