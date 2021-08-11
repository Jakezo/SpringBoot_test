package com.example.test.repository;

public class LamdaTest {
    interface MyInterface {
        void test();
    }
    interface MyType {
        void hello();
    }
    interface YourType {
        void talk(String msg);
    }
    public static void main(String[] args) {
        MyInterface my1 = new MyInterface() { //  new 키워드로 객체 직접 대입
            @Override
            public void test() {  // 메소드까지 클래스에 기재하는 것처럼 선언 -> 비용심화
                System.out.println("t라러리");
            }
        };
        my1.test(); //메소드사용
        MyType my2 = new MyType() {
            @Override
            public void hello() {
                System.out.println("안녕하세요. 홍길동입니다.");
            }
        };
        my2.hello(); // 메소드사용

        MyType my3 = () -> {  //이런식으로 익명객체를 생성 후 그 안에 오버라이딩 메소드 내용을 기재
            System.out.println("안녕하세요 아무개입니다.");
        }; // 단일라인 메소드
        my3.hello();

        YourType you = name -> System.out.println(name);

        you.talk("홍길동");



       /* MyType my4 = (String message) -> {
            System.out.println("안녕하세요.");
            System.out.println(message+"입니다.");
            System.out.println("감사합니다.");
        };
        my4.hello("홍길동");*/
    }
}
