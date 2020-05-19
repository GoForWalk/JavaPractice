const dog = {
    name : "멍멍이",
    sound : "멍멍!",

    // 객체안의 함수 정의하는 다양한 방법들

    // 방법1
    say1 : function aaa(){
        console.log(this.sound); // this 는 함수가 위치한(소유한) 객체
    },

    // 방법2
    say2 : function() {
        console.log(this.sound);
    },

    // 최신 js 방식(추천)
    say3(){
        console.log(this.sound);
    },

    // 화살표 함수의 경우..
    say4 : () => {
        console.log(this.sound);
        console.log(this);
    }

}

dog.say1();
dog.say2();
dog.say3();
dog.say4();

console.log('----------- cat --------------');

const cat = {
    name : 'kitty',
    sound : 'meow'


}

// cat.say1();
cat.say1 = dog.say1;

dog.say1();
cat.say1(); // 이떄 this 는 cat이 된다.

const sayCat = cat.say1;
console.log(typeof sayCat); // function
sayCat(); // this에 아무것도 '연결' 되지 않는다! this 는 undefined!



