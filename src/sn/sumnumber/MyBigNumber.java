package sn.sumnumber;

public class MyBigNumber {
	public String sum(String s1, String s2) {
		
		//lấy độ dài 2 chuỗi
		int len1 = s1.length();
		int len2 = s2.length();
		
		// sử dụng StringBuilder và phương thức reverse() để đảo chuỗi 
		StringBuilder str1 = new StringBuilder(s1).reverse();
		StringBuilder str2 = new StringBuilder(s2).reverse();
		
		char[] chr1, chr2; // chr1 là chuỗi dài chr2 là chuỗi ngắn h
		int n1, n2; // n1 dể lưu độ dài của chuỗi dài hơn, n2 lưu độ dài của chuỗi ngắn h
		
		/*xét xem chuỗi nào dài hơn để lấy độ dài chuỗi đó lưu vào n1 dùng để chạy vòng lặp 
		 * và đồng thời chuyển chuổi vừa đâỏ thành mảng ký tự char*/
		if (len1 >= len2) {
			n1 = len1;
			n2 = len2;
			chr1 = str1.toString().toCharArray();
			chr2 = str2.toString().toCharArray();
		} else {
			n1 = len2;
			n2 = len1;
			chr1 = str2.toString().toCharArray();
			chr2 = str1.toString().toCharArray();
		}
		int tmp = 0, num1, num2, i = 0; //biến tmp dùng để lưu giá trị hàng chục của kết quả phép toán lớn hơn 9
		int sumTmp; //dùng để lưu giá trị mỗi lần cộng 2 số
		String str; //dùng để lưu giá trị kiểu chuôi của kết quả phép c
		String sumStr = ""; // khởi tạo chuỗi kêt quả bằng r
		
		//chạy vòng lặp while để gọi các giá trị được luu trong mảng char 
		while (i < n1) {
			char[] chrTmp; // dùng để lưu tạm giá trị kết quả phép toán để tiến hành nối chuỗi thành chuỗi kết q
			
			/* Chạy vòng lăp chuyển các ký tự char trong mảng thành số nguyên thông qua bảng mã ascii 
			 * vd ki tự '1' có mã ascii là 49 khi trừ với kí tự '0' có mã ascii là 48 sẽ ra được 1 số nguyên là 1.
			 * Tương tự vậy ta có: 
			 * '2'=50 
			 * '3'=51 
			 * .. 
			 * '9'=57*/
			num1 = chr1[i] - '0';
			
			 /*so sánh điều kiện nếu i còn nhỏ hơn độ dài chuỗi ngắn  thì chuyển kí tự đó thành sô 
			 và tính tổng của num1 ,num2 và tmp. Nếu i >= độ dài chuỗi ngắn thì chỉ cộng num1 với tmp*/
			if (i < n2) {
				num2 = chr2[i] - '0';
				sumTmp = num1 + num2 + tmp;
			} else {
				sumTmp = num1 + tmp;
			}
			
			/*tăng i để tiếp tục cộng số kế tiếp của 2 chữ cũng như để kiểm tra nếu i = với độ của n1 
			 * và kết quả lớn hơn 9 thì if tiếp theo sẽ lấy ký tự của hàng chục của kết quả cộng vào
			 * cuối chuỗi sumStr*/
			i++;
			
			
			/*chuyển giá trị tổng thành kiểu chuỗi*/
			str = sumTmp + "";
			chrTmp = str.toCharArray(); // chuyển chuỗi str thành mảng ký tự
			
			/*xét điều kiện nếu độ dài mảng kí tự có 2 ký tự tức là kết quả phép cộng có giá trị lớp hơn 9 
			 * thì tiến hành cộng chuỗi bằng ký tự cuối của chuỗi còn ký tự đầu của chuỗi gán cho biến tạm tmp
			 * để cộng tiếp vào lần cộng 2 số tiếp theo. Nếu chỉ có 1 ký tự tứ là kết quả nhỏ hơn 9 thì chỉ 
			 * cộng chuỗi và gán lại biến tạm tmp=0 */
			if (chrTmp.length == 2) {
				sumStr += chrTmp[1] + "";
				if(i==n1) {
					sumStr +=chrTmp[0];
				}else {
					tmp = chrTmp[0] - '0';
				}
			} else {
				sumStr += chrTmp[0] + "";
				tmp = 0;
			}
		}
		
		//đảo chuỗi lại lần nữa vì kết quả là của 2 chuỗi đã bị đảo từ trước để tính t
		StringBuilder reStr = new StringBuilder(sumStr).reverse();
		return reStr.toString();
	}

}