import java.util.Arrays;
import java.util.Scanner;

import java.text.SimpleDateFormat;

import java.util.Date;

public class TPJ_Food {


    static Scanner sc = new Scanner(System.in);

    static Date date = new Date();


    // 사용자의 이름
    static String userName;

    // 사용자의 배열을 조회하기 위한 번호
    static int userInfor = 0;

    // 사용자의 ID, PW, Name의 배열
    static String[][] user = {
            {"ID1", "ID2", "ID3"},
            {"PW1", "PW2", "PW3"},
            {"가", "나", "다"}
    };

    //신규음식점 등록배열
    static java.lang.String[][] market = {};

    //메뉴 목록
    static String[][] menu = {
            {"떡볶이", "오뎅", "김말이"},
            {"짜장면", "짬뽕", "탕수육"},
            {"파스타", "피자", "리조또"}
    };
    //메뉴 가격
    static int[][] price = {
            {3000, 2500, 2000},
            {5000, 6000, 10000},
            {10000, 20000, 10000}
    };

    //판매개수 변수선언
    static int sellNum = 0;
    //판매된 메뉴가격변수선언
    static int sellMenuPrice = 0;

    //합산변수
    static int total = 0;

    //판매된 메뉴이름변수
    static String sellMenuName = "";

    // 고객 조회 idx
    static int idx = 0;


    //재사용 변수
    static String newID = "";
    static String newPW = "";
    static String registration = "";
    static boolean firstRegister = false;

//    ===================================================================================

    //메소드 선언

    // 초기 메세지 메소드
    static void message() {
        System.out.println("메뉴를 선택 해주세요.");
        System.out.println();
        System.out.println("1. 회원가입 진행");
        System.out.println("2. 로그인 진행");
        System.out.println("0. 프로그램 종료");
        System.out.println();
        System.out.print(">> ");
    }


    // 회원가입 메소드
    static void register() {
        int passNum = 0;
        System.out.print(">> ");
        String newID = sc.next();
        for (int i = 0; i < user.length; i++) {
            if (user[0][i].equals(newID)) {
                passNum = 1;
                break;
            } else passNum = 0;
        }
        if (passNum == 0) {
            System.out.println();
            System.out.println("사용 가능한 아이디입니다.");
            System.out.println("가입을 계속 진행합니다.");
            System.out.println();
        } else {
            System.out.println("중복된 ID 입니다.");
            System.out.println("ID를 다시 입력해주세요.");
        }
        if (passNum == 0) {
            System.out.println("");
            System.out.println("사용하실 비밀번호를 입력해주세요.");
            System.out.print(">> ");
            String newPW = sc.next();
            sc.nextLine();

            System.out.println();
            System.out.printf("사용자 이름: %s 사장님\n", userName);
            System.out.printf("ID: %s\n", newID);
            System.out.printf("PW: %s\n", newPW);
            System.out.println();
            System.out.println("회원가입이 성공적으로 완료되었습니다!");
            firstRegister = true;

            String temp[][] = new String[user.length + 1][user.length + 1];
            for (int i = 0; i < user.length; i++) {
                temp[0][i] = user[0][i];
                temp[1][i] = user[1][i];
                temp[2][i] = user[2][i];
                userInfor = i;
            }

            temp[0][user.length] = newID;
            temp[1][user.length] = newPW;
            temp[2][user.length] = userName;

            user = temp;
            temp = null;
        }
    }

    // 로그인 메소드
    static void login() {
        // 비밀번호를 통과시키기 위한 번호
        while (true) {
            System.out.print("ID >> ");
            String ID = sc.next();
            int passNum = 0;
            for (int i = 0; i < user.length; i++) {
                if (user[0][i].equals(ID)) {
                    passNum = 1;
                    break;
                } else passNum = 0;
            }
            if (passNum == 1) {
                break;
            } else {
                System.out.println("아이디를 다시 입력해주세요.");
            } // end if
        } // end while 1
        System.out.println("비밀번호를 입력하세요.");
        while (true) {
            // 비밀번호를 통과시키기 위한 번호
            int passPW = 0;
            System.out.print("PW >> ");
            String PW = sc.next();
            for (int i = 0; i < user.length; i++) {
                if (user[1][i].equals(PW)) {
                    passPW = 1;
                    userInfor = i;
                    break;
                } else passPW = 0;
            }

            if (passPW == 1) {
                System.out.println();
                System.out.println("로그인에 성공하였습니다.");
                System.out.println(user[2][userInfor] + " 사장님 접속을 환영합니다.");
                break;
            } else {
                System.out.println("비밀번호를 다시 입력해주세요.");
            }
        }
    }

    //로그인 했을 때, 회원가입 유저와 기존 유저의 메세지 출력 메소드
    static void loginMessage() {
        System.out.println();
        if (firstRegister == true) {
            System.out.println(" 1. 신규 음식점 등록");
            System.out.println(" 2. 가게 관리");
            System.out.print(">> ");
        } else {
            System.out.printf("%s 사장님 접속을 환영합니다.", user[2][userInfor]);
            System.out.println("");
            System.out.println(">> 처리하실 업무를 선택하세요.");
            System.out.println("");
            System.out.println("1. 가게관리");
            System.out.println("### 새로운 서비스 도입 준비 중 입니다.");
            System.out.print(">> ");
        }
    }

    //신규음식점 등록 메소드
    private static void newRegistration() {
        System.out.println("신규 음식점 이름을 입력해주세요.");
        String newFoodMarket = sc.next();

        String[][] temp = new String[market.length + 1][market.length + 1];
        int i = 0;
        for (i = 0; i < market.length; i++) {
            temp[i][idx] = market[idx][i];
        }

        temp[market.length][market.length] = newFoodMarket;

        market = temp;
        temp = null;

        System.out.printf("%s님의 새로운 음식점:%s이 등록되었습니다.\n", user[2][idx], market[i][i]);
        System.out.printf("축하드립니다!!!!\n");
        return;
    }

    //매출관리 메소드
    private static void salesManagement(String setTime1) {
        while (true) {
            //해당 점포의 메뉴 띄우기
            String selectUser = user[2][userInfor];
            for (int j = 0; j < user.length; j++) {
                if (selectUser.equals(user[2][j])) {
                    System.out.printf("%s 사장님 가게의 메뉴 목록입니다.", user[2][userInfor]);
                    System.out.println(Arrays.toString(menu[userInfor]));
                }
            }

            System.out.println("매출을 등록하실 메뉴를 입력해주세요");
            System.out.println("업무를 마치시려면 '0' 을 입력해주세요");
            System.out.print(">> ");
            String menuName = sc.next();

            //합산목록
            //입력한 목록 찾기
            for (int k = 0; k < menu.length; k++) {
                for (int l = 0; l < menu.length; l++) {
                    if (menu[k][l].equals(menuName)) {
                        sellMenuName = menuName;
                        System.out.println("판매하신 수량을 입력해주세요.");
                        System.out.print(">> ");
                        sellNum = sc.nextInt();
                        sellMenuPrice = price[k][l];
                    }//end if
                }//end inner for
            }//end outer for
            total += sellMenuPrice * sellNum;

            //0을 입력했을 시 총 수익과 함께 종료
            if (menuName.equals("0")) {
                System.out.printf("%s 판매수익: %d\n", setTime1, total);
                break;
            }
            System.out.printf("%s 판매수익: %d\n", setTime1, total);

        }//end while
    }

    public static void main(String[] args) {

        //현재 시간
        SimpleDateFormat timedata = new SimpleDateFormat("y.MM.dd a hh:mm:s");
        String setTime1 = timedata.format(date);


        // 프로그램 실행 초기 화면
        System.out.println();
        System.out.println("ISEC 음식점 관리 프로그램을 실행합니다.");
        System.out.println("점주님들의 번창을 기원합니다.");
        System.out.println();

        // 회원가입
        while (true) {
            //초기 메세지 출력
            message();
            int registerNum = sc.nextInt();
            switch (registerNum) {
                case 1:
                    System.out.println();
                    System.out.println("사용자의 성함을 입력해주세요.");
                    System.out.print(">> ");
                    userName = sc.next();
                    System.out.println();
                    System.out.println("사용하실 아이디를 입력해주세요.");
                    while (true) {
                        register();
                        break;
                    } // end while
                case 2:
                    // 로그인
                    System.out.println();
                    System.out.println("아이디를 입력하세요.");
                    login();
                    break;
                case 0:
                    // 프로그램 종료
                    System.out.println("사용자의 요청에 의해 프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("메뉴 목차 번호를 정확히 입력해주세요.");
                    break;
            }
            break;
        }
        // END LOGIN SYSTEM

        //로그인 이후 메세지, 업무처리
        while (true) {
            // 회원가입 , 기존 유저의 메세지 출력
            loginMessage();

            // 다음 일처리를 하기위한 번호 선택
            String number = sc.next();

            System.out.println();
            System.out.println(">> 처리하실 업무를 선택하세요.");
            System.out.println();
            System.out.println(" 1. 신규 음식점 등록");
            System.out.println(" 2. 가게 관리");
            System.out.print(">> ");
            number = sc.next();

            switch (number) {
                case "1":
                    //신규음식점 등록
                    newRegistration();
//                    break;


                case "2":
                    System.out.println("처리하실 업무의 번호를 선택하세요.");
                    System.out.println("0. 나가기");
                    System.out.println("1. 상호명 변경");
                    System.out.println("2. 메뉴판 수정");//메뉴 삭제, 가격수정, 메뉴이름 수정
                    System.out.println("3. 매출관리");
                    System.out.println("4. 정산관리");
                    System.out.print(">");
                    int rsNumber = sc.nextInt();

                    //가게관리
                    switch (rsNumber) {
                        case 0:
                            System.out.println("업무를 마칩니다.");
                            break;
                        case 1://상호명 변경

                        case 3://매출관리

                            salesManagement(setTime1);
                            continue;

                        case 4://정산관리
                            System.out.printf("판매된 메뉴: %s : %d\n", sellMenuName, sellMenuPrice);
                            System.out.printf("오늘의 총 수익: %d", total);
                            break;

                    }//end switch

                    break;

                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }//end switch
            break;
        }//end while


    } // end main




}//end class