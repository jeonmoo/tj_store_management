package test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import discard.DaoDiscard;
import discard.DiscardDaoImpl;
import discard.Dtodiscard;
import merchandise.DaoMerchandise;
import merchandise.DtoMerchandise;
import merchandise.MerchandiseDaoImpl;
import order.DaoOrder;
import order.DtoOrder;
import order.OrderDaoImpl;
import sales.DaoSales;
import sales.DtoSales;
import sales.SalesDaoImpl;


public class Test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		DaoMerchandise dao = MerchandiseDaoImpl.getInstance();
		DaoOrder daoO = OrderDaoImpl.getInstance();
		DaoDiscard daod = DiscardDaoImpl.getInstance();
		DaoSales daos = SalesDaoImpl.getInstance();

		try {

			//입력받은 아이디, 패스워드값으로 계정 접속
			//로그인시스템만들기
			System.out.println("프로그램 시작");
			System.out.println("id와 password를 입력해주세요");
			String id = scan.next();
			String pass = scan.next();

			//MyConn.getConn(id, pass);

			//홈
			System.out.println(id+"님 환영합니다!");
			while(true){
				System.out.println("원하시는 기능의 번호를 입력해주세요");
				System.out.println("1. 조회\n2. 판매\n3. 입고\n4. 재고정보수정\n5. 발주\n6. 폐기");
				int fun = scan.nextInt();


				//------------------------------------------------------------------------------------------------------------------


				//조회기능
				if(fun == 1) {
					System.out.println("---조회---");
					System.out.println("어떤것을 조회하시겠습니까?");
					System.out.println("1. 재고조회\n2. 판매목록조회\n3. 발주목록조회\n4. 폐기기록조회");
					int select = scan.nextInt();

					//재고조회
					while(select == 1) {
						System.out.println("재고조회입니다");
						System.out.println("1. 품번으로 검색");
						System.out.println("2. 제품명으로 검색");
						int selectWhere = scan.nextInt();
						if(selectWhere == 1) {
							System.out.println("검색할 제품의 품번을 입력해주세요");
							int selectId = scan.nextInt();
							//품번으로 select하는 코드
							DtoMerchandise merc = dao.merchandiseFindById(selectId);
							System.out.println(merc);

							System.out.println("계속 조회하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}

						}else if(selectWhere == 2) {
							System.out.println("검색할 제품의 이름을 입력해주세요");
							String merName = scan.next();
							//이름으로 select하는 코드
							List<DtoMerchandise> merList = dao.merchandiseFindByName(merName);

							for(DtoMerchandise dtoMerchandise : merList) {
								System.out.println(dtoMerchandise);
							}
							if(merList == null) {
								System.out.println("검색결과가 없습니다");
							}

							System.out.println("계속 조회하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}

						}else {
							System.out.println("잘못입력하셨습니다 다시 입력하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}
						}
					}

					//판매기록조회
					while(select == 2) {
						System.out.println("판매목록조회입니다");
						System.out.println("1. 전체조회");
						System.out.println("2. 날짜조회");
						int selectWhere = scan.nextInt();
						if(selectWhere == 1) {
							System.out.println("전체 판매기록입니다");
							//판매기록전체조회하는 코드
							List<DtoSales> salesList = daos.salesFindAll();
							for(DtoSales sList : salesList) {
								System.out.println(sList);
							}

							System.out.println("계속 조회하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}

						}else if(selectWhere == 2) {
							scan.nextLine();
							//기간입력받아 조회하는 코드
							System.out.println("조회하시려는 판매기록의 시작일을 입력해주세요");
							String selectStart = scan.nextLine();
							System.out.println("조회하시려는 판매기록의 마지막날을 입력해주세요");
							String selectEnd = scan.nextLine();


							List<DtoSales> sales = daos.salesFindTerm(selectStart, selectEnd);
							for(DtoSales sList : sales) {
								System.out.println(sList);
							}
							System.out.println("계속 조회하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}

						}else {
							System.out.println("잘못입력하셨습니다 다시 입력하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}
						}
					}

					//발주목록조회
					while(select == 3) {
						System.out.println("현재발주목록");
						//오더리스트 불러오는 코드
						List<DtoOrder> ordList = daoO.orderListFindAll();
						for(DtoOrder orderList : ordList) {
							System.out.println(orderList);
						}
						break;
					}

					//폐기목록 조회
					while(select == 4) {
						System.out.println("폐기목록조회입니다");
						System.out.println("1. 전체조회");
						System.out.println("2. 날짜조회");
						int selectWhere = scan.nextInt();
						if(selectWhere == 1) {
							System.out.println("전체 폐기기록입니다");
							//전체 폐기기록을 출력하는 코드
							List<Dtodiscard> disList;
							disList = daod.discardFindAll();
							for(Dtodiscard dList : disList) {
								System.out.println(dList);
							}

							System.out.println("계속 조회하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}

						}else if(selectWhere == 2) {
							scan.nextLine();
							//기간을 정해서 출력하는 코드
							System.out.println("조회하시려는 폐기기록의 시작시간을 입력해주세요");
							String selectStart = scan.nextLine();
							System.out.println("조회하시려는 폐기기록의 마지막시간을 입력해주세요");
							String selectEnd = scan.nextLine();

							List<Dtodiscard> disList = daod.discardFindTerm(selectStart, selectEnd);
							for(Dtodiscard dList : disList) {
								System.out.println(dList);
							}

							System.out.println("계속 조회하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}

						}else {
							System.out.println("잘못입력하셨습니다 다시 입력하시겠습니까? y or n");
							String ans = scan.next();
							if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
								break;
							}
						}
					}
				}

				//--------------------------------------------------------------------------------------------------------


				//판매기능
				while(fun == 2) {
					System.out.println("---판매---");
					//				int sales = scan.nextInt();
					System.out.println("판매하시려는 제품의 품번을 입력해주세요");
					int id1 = scan.nextInt();
					//품번으로 검색해서 재고목록에서 지우고 판매목록에 기록하는 코드
					//재고목록에서 삭제
					int removeMer = dao.delete(id1);
					System.out.println(removeMer+"줄삭제");

					//판매목록에 삽입
					//sales_list - sales_id, merchandise_id, category, name, quantity, price, sales_datetime
					int salesId = 0;
					System.out.println("품목을 입력하세요");
					String category = scan.next();
					System.out.println("제품명을 입력하세요");
					String name = scan.next();
					System.out.println("수량을 입력하세요");
					int quantity = scan.nextInt();
					System.out.println("가격을 입력하세요");
					int price = scan.nextInt();
					LocalDateTime salesDatetime = LocalDateTime.now();

					DtoSales insertSales = new DtoSales(salesId, id1, category, name, quantity, price, salesDatetime);
					daos.sales(insertSales);
					System.out.println(insertSales+"적용완료!");


					System.out.println("계속 판매하시겠습니까? y or n");
					String ans = scan.next();
					if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
						break;
					}

				}



				//--------------------------------------------------------------------------------------------------------


				//입고기능
				while(fun == 3) {
					System.out.println("---입고---");
					System.out.println("입고하시려는 제품의 정보를 입력해주세요");
					// id,category,name,quantity,price,expiration_date

					int id1 = 0;

					System.out.println("제품군을 선택해수세요");
					String category = scan.next();
					//DtoMerchandise의 필드로 반환

					System.out.println("제품명을 입력해주세요");
					String name = scan.next();
					//DtoMerchandise의 필드로 반환

					System.out.println("수량을 입력하세요");
					int quantity = scan.nextInt();
					//DtoMerchandise의 필드로 반환

					System.out.println("가격을 입력하세요");
					int price = scan.nextInt();
					//DtoMerchandise의 필드로 반환
					scan.nextLine();

					System.out.println("유튱기한을 입력해주세요(없으면 x입력)");
					String expDate = scan.nextLine();

					//유통기한입력값 다시 수정하기(x를 눌렀을때 해결해야함)
					if(expDate.equals("X") || expDate.equals("x") || expDate.equals("ㅌ")) {
						expDate = null;
					}
					LocalDateTime expirationDate = LocalDateTime.parse(expDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					//DtoMerchandise의 유통기한 필드로 반환


					DtoMerchandise input = new DtoMerchandise(id1, category, name, quantity, price, expirationDate);
					dao.insert(input);
					System.out.println(input+"적용완료!");


					System.out.println("더 추가하시겠습니까? y or n");
					String ans2 = scan.next();
					if(ans2.equals("N") || ans2.equals("n") || ans2.equals("ㅜ")) {
						break;
					}
				}



				//--------------------------------------------------------------------------------------------------------


				//재고정보수정기능
				while(fun == 4) {
					System.out.println("---재고정보수정---");
					System.out.println("1. 품번으로 수정\n2. 제품명으로 수정");
					int update = scan.nextInt();

					//id로 조회후 수정
					if(update == 1) {
						System.out.println("품번을 입력해주세요");
						int updateId1 = scan.nextInt();
						//where id = ?로 수정하는 코드
					}

					//제품명으로 조회후 수정
					if(update == 2) {
						System.out.println("제품명을 입력해주세요");
						String updateId2 = scan.next();
						//where name = ?로 수정하는 코드
					}

					System.out.println("더 수정하시겠습니까? y or n");
					String ans = scan.next();
					if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
						break;
					}
				}



				//--------------------------------------------------------------------------------------------------------



				//발주기능(
				while(fun == 5) {
					System.out.println("---발주목록---");
					System.out.println("발주하시려는 제품의 정보를 입력해주세요");
					//order_id, merchandise_id, category, name, quantity, price

					//order_id 반환해주는 코드

					int ordId = 0;

					System.out.println("품번을 입력해주세요");
					int id1 = scan.nextInt();

					System.out.println("제품군을 선택해수세요");
					String category = scan.next();
					//DtoMerchandise의 필드로 반환

					System.out.println("제품명을 입력해주세요");
					String name = scan.next();
					//DtoMerchandise의 필드로 반환

					System.out.println("수량을 입력하세요");
					int quantity = scan.nextInt();
					//DtoMerchandise의 필드로 반환

					System.out.println("가격을 입력하세요");
					int price = scan.nextInt();
					//DtoMerchandise의 필드로 반환

					DtoOrder order = new DtoOrder(ordId, id1, category, name, quantity, price);

					daoO.insert(order);
					System.out.println(order+"적용완료!");
					System.out.println("발주를 계속 하시겠습니까? y or n");
					String ans = scan.next();
					if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
						break;
					}
				}


				//--------------------------------------------------------------------------------------------------------



				//폐기기능
				while(fun == 6) {

					System.out.println("---폐기기능---");
					System.out.println("수행할 기능을 선택해주세요");
					System.out.println("1. 품번로 검색\n2. 제품명으로 검색");
					int delete = scan.nextInt();

					//id로 폐기
					if(delete == 1) {
						System.out.println("품번을 입력해주세요");
						int id1 = scan.nextInt();
						//입력받은 품번으로 재고목록에서 삭제하고 폐기목록에 삽입하는 코드
						//재고목록에서 삭제하는코드
						int removeMer = dao.delete(id1);
						System.out.println(removeMer+"줄삭제");

						//폐기목록에 삽입하는 코드
						//discard_id, merchandise_id, category, name, quantity, price, discard_datetime
						int discardId = 0;
						System.out.println("제품군을 선택하세요");
						String category = scan.next();
						System.out.println("제품명을 입력하세요");
						String name = scan.next();
						System.out.println("수량을 입력하세요");
						int quantity = scan.nextInt();
						System.out.println("가격을 입력하세요");
						int price = scan.nextInt();
						LocalDateTime discardDatetime = LocalDateTime.now();

						Dtodiscard disInsert = new Dtodiscard(discardId, id1, category, name, quantity, price, discardDatetime);
						daod.insertDiscard(disInsert);
						System.out.println(disInsert +"적용완료!");
					}

					System.out.println("계속 폐기하시겠습니까? y or n");
					String ans = scan.next();
					if(ans.equals("N") || ans.equals("n") || ans.equals("ㅜ")) {
						break;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
