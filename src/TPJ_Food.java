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
            {"id1", "id2", "id3"},
            {"pw1", "pw2", "pw3"},
            {"사장님1", "사장님2", "사장님3"}
    };

    //신규음식점 등록배열
    // idx = user
    static java.lang.String[] market = {"분식집", "중식집", "레스토랑"};

    //메뉴 목록
    static String[][] menu = {
            {"떡볶이", "오뎅", "김말이"},
            {"짜장면", "짬뽕", "탕수육"},
            {"파스타", "피자", "리조또"},
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

    //판매, 정산관리에서 추출하기 위해 사용하는 메뉴리스트와 가격리스트 변수
    static String[] sellMenuList = {};
    static int[] sellNumList = {};

    static int MI = 0;


    // 고객 조회 idx
    static int idx = 0;


    //재사용 변수
    static String newID = "";
    static String newPW = "";
    static String registration = "";
    static boolean firstRegister = false;
    private static int sum;

//    ===================================================================================

    //메소드 선언

    static void changemenuName() {
        String changeMenuname = "";
        int cmi = 0;
        int cmi2 = 0;
        boolean correct = false;
        int select = 0;
        String MN;
        int CP;

        System.out.println("메뉴판 설정");
        System.out.println("1. 가격변경");
        System.out.println("2. 메뉴이름 변경");
        System.out.println("3. 메뉴추가");
        select = sc.nextInt();

        switch (select) {
            case 1:
                System.out.println(Arrays.toString(menu[idx]));
                System.out.println(Arrays.toString(price[idx]));
                System.out.println("가격을 변경할 메뉴를 입력해주세요.");
                MN = sc.next();

                for (int i = 0; i < user[0].length; i++) {
                    if (MN.equals(menu[userInfor][i])) {
                        MI = i;
                        break;
                    }
                }

                System.out.println("원래 가격 :" + price[userInfor][MI]);
                System.out.println("변경할 가격을 입력하세요");
                System.out.print(">> ");
                CP = sc.nextInt();
                System.out.println("");

                price[userInfor][MI] = CP;
                System.out.println(Arrays.toString(menu[userInfor]));
                System.out.println(Arrays.toString(price[userInfor]));

                System.out.println("수정된 가격 :" + price[userInfor][MI]);
                break;
            case 2:
                while (true) {

                    System.out.println(Arrays.toString(menu[idx]));
                    System.out.println("수정할 메뉴 이름을 입력해주세요.");
                    System.out.print(">>>");
                    String menuName = sc.next();


                    for (int i = 0; i < menu.length - 1; i++) {
                        if (menuName.equals(menu[idx][i])) {
                            cmi = idx;
                            cmi2 = i;
                            correct = true;
                            break;
                        }

                    }
                    if (!correct) {
                        System.out.println("메뉴목록에 메뉴가 등록되어 있지 않습니다.");
                        System.out.println("다시 입력해주세요.");
                        continue;
                    }

                    if (correct) {
                        System.out.println("수정할 메뉴 이름을 입력해주세요.");
                        System.out.print(">>");
                        changeMenuname = sc.next();
                        break;

                    }
                }
                menu[cmi][cmi2] = changeMenuname;
                System.out.println(Arrays.toString(menu[idx]) + "으로 수정되었습니다.");
                break;

            case 3:
                System.out.println("추가할 메뉴 이름을 입력하세요");
                String NMN = sc.next();
                int mi = 0;
                boolean cm = false;
                for (int f = 0; f < user[0].length; f++) {
                    if (NMN.equals(menu[userInfor])) {
                        mi = f;
                        cm = true;
                        break;
                    }
                }

                System.out.println("추가 메뉴의 가격을 입력하세요");
                int NMP = sc.nextInt();

//

                int[][] temp1 = new int[user[0].length+1][price[userInfor].length +1];
                String[][] temp2 = new String[user[0].length+1][menu[userInfor].length +1];

                for (int i = 0; i < menu.length; i++) {
                    for (int j = 0; j < menu[i].length; j++) {
                        temp2[i][j] = menu[i][j];
                        temp1[i][j] = price[i][j];
                    }
                }

                for (int i = 0; i < menu[userInfor].length; i++) {
                    temp2[userInfor][i] = menu[userInfor][i];
                }

                temp2[idx][menu[userInfor].length] = NMN;
                temp1[idx][price[userInfor].length] = NMP;

                price = temp1;
                menu = temp2;
                temp1 = null;
                temp2 = null;

                System.out.println(Arrays.toString(menu[idx]));
                System.out.println(Arrays.toString(price[idx]));


        }


    }

    static void changeName() {
        System.out.printf("%s 사장님의 상호명 [%s] 입니다.\n", user[2][idx], market[idx]);
        System.out.println("변경하실 상호명을 입력하세요.");

        String changemarketName;
        System.out.print(">>");
        changemarketName = sc.next();


        market[idx] = changemarketName;

        System.out.println(Arrays.toString(new String[]{market[idx]}) + "으로 수정됨");


    }

    // 초기 메세지 메소드
    static void message() {
        System.out.println("원하시는 메뉴를 선택하세요.");
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
            }
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

            // 데이터를 옮기기 위한 임시 배열 생성
            // user[0].length = 사장님의 id수 = 사장님의 현재 수 (1:1)
            // 사장님이 추가되면 사장님 정보의 id, pw, 이름 배열, 메뉴베열, 가격배열 이 1칸 늘어나야 함 - menu[이부분][]
            // menu[0][] 는 1번째 사장님의 메뉴들이기 때문에 사장님(식당)별 갯수가 다름
            // 그러므로 각 사장님 별 메뉴와 가격의 칸을 늘릴수 없음

            String temp[][] = new String[user.length][user[0].length + 1];
            String temp1[][] = new String[user[0].length + 1][];
            int[][] temp2 = new int[user[0].length + 1][];
            for (int i = 0; i < user[0].length; i++) {
                temp[0][i] = user[0][i];
                temp[1][i] = user[1][i];
                temp[2][i] = user[2][i];

                //메뉴정보옮김
                temp1[i] = menu[i];

                //가격정보옮김
                temp2[i] = price[i];

            }

            temp[0][temp[1].length - 1] = newID;
            temp[1][temp[1].length - 1] = newPW;
            temp[2][temp[1].length - 1] = userName;

            temp1[temp1.length - 1] = new String[]{"메뉴입력1", "메뉴입력2", "메뉴입력3"};

            temp2[temp2.length - 1] = new int[]{1000, 1000, 1000};


            price = temp2;
            temp2 = null;

            menu = temp1;
            temp1 = null;

            user = temp;
            temp = null;

        }

        System.out.println(Arrays.deepToString(user));
        System.out.println(Arrays.toString(market));
        System.out.println(Arrays.deepToString(menu));
        System.out.println(Arrays.deepToString(price));

    }

    // menu 2 메세지
    private static void workMenu() {
        System.out.println("처리하실 업무의 번호를 선택하세요.");
        System.out.println("0. 나가기");
        System.out.println("1. 상호명 변경");
        System.out.println("2. 메뉴판 수정");//메뉴 삭제, 가격수정, 메뉴이름 수정
        System.out.println("3. 매출관리");
        System.out.println("4. 정산관리");
        System.out.print(">> ");
    }


    //로그인 메소드
    static void login() {
        // 비밀번호를 통과시키기 위한 번호
        String ID = "";
        while (true) {
            System.out.print("ID >> ");
            ID = sc.next();
            int passNum = 0;
            for (int i = 0; i < user[0].length; i++) {
                if (user[0][i].equals(ID)) {
                    passNum = 1;
                    idx = i;
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
            if (!PW.equals(user[1][idx])) {
                System.out.println("비밀번호가 맞지않습니다.");
                continue;
            }
            for (int i = 0; i < user[0].length; i++) {
                if (user[1][i].equals(PW)) {
                    passPW = 1;
                    userInfor = i;
                    idx = i;
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
        if (user.length == 0) return;
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

        String[] temp1 = new String[market.length + 1];

        int i = 0;
        for (i = 0; i < market.length; i++) {
            temp1[i] = market[i];
        }

        temp1[temp1.length - 1] = newFoodMarket;
        market = temp1;
        temp1 = null;
        System.out.println(Arrays.toString(market));
        System.out.printf("%s 사장님의 %s 식당이 개업되었습니다.\n", user[2][idx], market[idx]);
        System.out.printf("사장님의 성공을 항상 기원합니다.\n");
    }


    //매출관리 메소드
    private static void salesManagement(String setTime1) {
        while (true) {
            //해당 점포의 메뉴 띄우기
            int total = 0;
            String selectUser = user[2][userInfor];
            for (int j = 0; j < user[0].length; j++) {
                if (selectUser.equals(user[2][j])) {
                    System.out.println("");
                    System.out.println("매출 입력을 시작합니다.");
                    System.out.println("업무를 마치시려면 '0' 을 입력해주세요.");
                    System.out.println("");
                    System.out.println(Arrays.toString(menu[userInfor]));
                }//end if
            }//end for

            System.out.println("매출을 입력하실 음식을 입력해주세요.");
            System.out.print(">> ");
            String menuName = sc.next();
            System.out.println("");

            //합산목록
            //입력한 목록 찾기

            //잘못입력했을 때 false로 반환되는 논리타입변수
            boolean corMenuName = false;

            for (int l = 0; l < menu[userInfor].length; l++) {
                if (menu[userInfor][l].equals(menuName)) {
                    sellMenuName = menuName;
                    System.out.println("판매하신 수량을 입력해주세요.");
                    System.out.print(">> ");
                    sellNum = sc.nextInt();
                    sellMenuPrice = price[userInfor][l];

                    corMenuName = true;

                    //만약 등록한 메뉴를 다시 등록할 경우
                    boolean isAlreadySelled = false;

                    for (int i = 0; i < sellMenuList.length; i++) {
                        if (menuName.equals(sellMenuList[i])) {
                            sellNumList[i] += sellMenuPrice * sellNum;
                            isAlreadySelled = true;
                        }
                    }
                    if (!isAlreadySelled) {
                        //메뉴와 가격을 꽂기 위한 빈배열 생성
                        String temp1[] = new String[sellMenuList.length + 1];
                        int temp2[] = new int[sellNumList.length + 1];
                        //메뉴이름배열과 가격배열에 꽂기
                        for (int i = 0; i < sellNumList.length; i++) {
                            temp1[i] = sellMenuList[i];
                            temp2[i] = sellNumList[i];
                        }
                        temp1[temp1.length - 1] = menuName;
                        temp2[temp2.length - 1] = sellNum * sellMenuPrice;
                        //메뉴, 가격 배열에 빈배열 복사
                        sellMenuList = temp1;
                        sellNumList = temp2;
                        temp1 = null;
                        temp2 = null;
                    }//end inner for
                    System.out.println("===== ** 판매된 음식 목록 ** =====");
                    System.out.printf("%s\n", setTime1);
                    System.out.println("");
                    //총수익
                    for (int i = 0; i < sellNumList.length; i++) {
                        System.out.printf("%s %d인분 [%s원]\n", sellMenuList[i], sellNum, sellNumList[i]);
                        total += sellNumList[i];
                        sum = total;
                    }
                    System.out.println("");
                    System.out.printf("총 판매 금액: %d\n", total);
                    System.out.println("");
                    System.out.println("===== ** 판매된 음식 목록 ** =====");
                    break;
                }//end if
            }//end outer for
            //잘못 입력했을 시
            if (!corMenuName) {
                if (!menuName.equals("0")) {
                    System.out.println("\n재입력 부탁드립니다.");
                    continue;
                }
            }//end if
            //0을 입력했을 시 총 수익과 함께 종료
            if (menuName.equals("0")) {
                corMenuName = true;
                System.out.printf("%s\n", setTime1);
                System.out.printf("현 시간 매출: %d\n", sum);
                break;
            }
        }//end while
    }//end method

    public static void main(String[] args) {

        //현재 시간
        SimpleDateFormat timedata = new SimpleDateFormat("y.MM.dd a hh:mm:s");
        String setTime1 = timedata.format(date);


        // 프로그램 실행 초기 화면
        System.out.println(market.length);
        System.out.println();
        System.out.println("ISEC 음식점 관리 프로그램을 실행합니다.");
        System.out.println("점주님들의 번창을 기원합니다.");
        System.out.println();

        // 회원가입
        while (true) {
            //초기 메세지 출력
            message();
            int registerNum = sc.nextInt();
            if (registerNum == 0) break;
            switch (registerNum) {
                case 1:
                    System.out.println();
                    System.out.println("사용자의 성함을 입력해주세요.");
                    System.out.print(">> ");
                    userName = sc.next();
                    System.out.println();
                    System.out.println("사용하실 아이디를 입력해주세요.");
                    register();
                    continue;
                    // end while
                case 2:
                    // 로그인
                    System.out.println();
                    System.out.println("아이디를 입력하세요.");
                    login();
                    break;

                default:
                    System.out.println("메뉴 목차 번호를 정확히 입력해주세요.");
                    break;
            }

            // END LOGIN SYSTEM

            //로그인 이후 메세지, 업무처리


            // 다음 일처리를 하기위한 번호 선택
            String number;

            System.out.println();
            System.out.println(">> 처리하실 업무를 선택하세요.");
            System.out.println();

            while (true) {
                System.out.println(" 1. 신규 음식점 등록");
                System.out.println(" 2. 가게 관리");
                System.out.print(">> ");
                number = sc.next();
                switch (number) {
                    case "1":
                        //신규음식점 등록
                        newRegistration();
                        continue;

                    case "2":
                        workMenu();
                        int rsNumber = sc.nextInt();

                        //가게관리
                        switch (rsNumber) {
                            case 0:
                                System.out.println("업무를 마칩니다.");
                                break;
                            case 1: // 상호명 변경
                                changeName();
                                continue;
                            case 2: //메뉴판 수정
                                changemenuName();
                                break;
                            case 3://매출관리
                                salesManagement(setTime1);
                                continue;
                            case 4://정산관리
                                System.out.println("");
                                for (int i = 0; i < sellNumList.length; i++) {
                                    System.out.printf("%s %d인분 [%s원]\n", sellMenuList[i], sellNum, sellNumList[i]);
                                    total += sellNumList[i];
                                }
                                System.out.println("오늘의 총 수입: " + total + "원");
                                break;

                        }//end switch

                        break;

                    default:
                        System.out.println("다시 입력해주세요.");
                        break;
                }//end switch
            }
        }//end while


    } // end main

}//end class