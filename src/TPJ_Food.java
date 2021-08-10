import java.util.Arrays;
import java.util.Scanner;

public class TPJ_Food {


    public static void main(String[] args) {

        //점주 정보
        String[][] user = {
                {"ID1", "ID2", "ID3"},
                {"PW1", "PW2", "PW3"},
                {"가", "나", "다"},


        };

        //메뉴배열 선언
        String[][] menu = {
                {"떡볶이", "오뎅", "김말이"},
                {"짜장면", "짬뽕", "탕수육"},
                {"파스타", "피자", "리조또"}
        };

        int[][] price = {
                {3000, 2500, 2000},
                {5000, 6000, 10000},
                {10000, 20000, 10000}
        };

        //재사용해야하는 변수목록 선언
        String newID = "";
        String newPW = "";
        String userName = "";
        String registration = "";


        //판매개수 변수선언
        int sellNum = 0;
        int priceNum = 0;
        //합산변수
        int total = 0;

        //신규 음식점생성시 음식의 종류에 따른 배열//일단 사용 안함
        String[] kind = new String[4];

        Scanner sc = new Scanner(System.in);

        // 프로그램 실행 초기 화면
        System.out.println();
        System.out.println("ISEC 음식점 관리 프로그램을 실행합니다.");
        System.out.println("점주님들의 번창을 기원합니다.");
        System.out.println();

        // 회원가입

        while (true) {
            System.out.println("메뉴를 선택 해주세요.");
            System.out.println();
            System.out.println("1. 회원가입 진행");
            System.out.println("2. 로그인 진행");
            System.out.println();
            System.out.print(">> ");
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
                        int passNum = 0;
                        System.out.print(">> ");
                        newID = sc.next();
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
                            newPW = sc.next();
                            sc.nextLine();

                            System.out.println();
                            System.out.printf("사용자 이름: %s 사장님\n", userName);
                            System.out.printf("ID: %s\n", newID);
                            System.out.printf("PW: %s\n", newPW);
                            System.out.println();
                            System.out.println("회원가입이 성공적으로 완료되었습니다!");


                            String temp[][] = new String[user.length + 1][user.length + 1];
                            for (int i = 0; i < user.length; i++) {
                                temp[0][i] = user[0][i];
                                temp[1][i] = user[1][i];
                                temp[2][i] = user[2][i];

                            }

                            temp[0][user.length] = newID;
                            temp[1][user.length] = newPW;
                            temp[2][user.length] = userName;


                            user = temp;
                            temp = null;
                            break;
                        }

                    }
                case 2:
                    // 로그인
                    System.out.println();
                    System.out.println("아이디를 입력하세요.");
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
                        int nameNum = 0;
                        System.out.print("PW >> ");
                        String PW = sc.next();
                        for (int i = 0; i < user.length; i++) {
                            if (user[1][i].equals(PW)) {
                                passPW = 1;
                                nameNum = i;
                                break;
                            } else passPW = 0;
                        }

                        if (passPW == 1) {
                            System.out.println("로그인에 성공하였습니다.");
                            System.out.println(user[2][nameNum] + " 사장님 접속을 환영합니다.");
                            break;
                        } else {
                            System.out.println("비밀번호를 다시 입력해주세요.");
                        }
                    }
            }
            break;
        }
        // END LOGIN SYSTEM

        //신규 음식점 등록
        while (true) {
            System.out.println();
            System.out.println(">> 처리하실 업무를 선택하세요.");
            System.out.println();

            System.out.println(" 1. 신규 음식점 등록");
            System.out.println(" 2. 가게 관리");
            System.out.print(">");
            String number = sc.next();

            switch (number) {
                case "1":
                    System.out.println("음식점 종류를 선택하세요");
                    System.out.println("1. 한식 2. 중식 3. 일식 4. 양식");
                    String kindName = sc.next();

                    System.out.println("상호명을 입력하세요.");
                    registration = sc.next();

                    //대체배열에 원본배열 복사
                    String temp[][] = new String[user.length + 1][user.length + 1];
                    for (int i = 0; i < user.length; i++) {
                        temp[0][i] = user[0][i];
                        temp[1][i] = user[1][i];
                        temp[2][i] = user[2][i];
                    }

                    temp[0][user.length] = newID;
                    temp[1][user.length] = newPW;
                    temp[2][user.length] = userName;
                    temp[3][user.length] = registration;

                    user = temp;
                    temp = null;
                    System.out.println("신규음식점이 등록되었습니다.");


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
                            System.out.println("현재 상호명을 입력하세요.");
                            String rsName = sc.next();

                            //상호명 변경 푸시
                            for (int i = 0; i < user.length; i++) {
                                if (user[i][i].equals(rsName)) {
                                    System.out.println(user[i][i] + " => 변경하실 상호명을 입력해주세요.");
                                    String changeName = sc.next();
                                    user[i][i] = changeName;
                                    System.out.println("변경이 완료되었습니다.");

                                }//end if

                            }//end for
//                            System.out.println("없는 이름입니다. 상호명을 다시 입력해주세요.");

                        case 3://매출관리
                            System.out.println(Arrays.toString(menu[0]));

                            //menu[] -> 점주의 인덱스 찾아서 넣어야 함
//                            int idx = -1;

                            System.out.println("판매된 목록을 입력해주세요");
                            String menuName = sc.next();

                            //합산목록
                            //입력한 목록 찾기
                            for (int i = 0; i < menu.length; i++) {
                                for (int j = 0; j < menu.length; j++) {
                                    if (menu[i][j].equals(menuName)) {
                                        System.out.println("개수를 입력해주세요.");
                                        sellNum = sc.nextInt();
                                        priceNum = price[i][j];
                                    }
                                }
                            }

                            total += priceNum * sellNum;
                            System.out.printf("판매수익: %d", total);
                            break;

                        case 4://정산관리
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