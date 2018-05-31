package sn.sumnumber;

public class NotReverse {
	public String sum(String s1, String s2) {
		int maxLen; // lưu độ dài chuỗi .
		String strSum=""; // lưu kết quả bài toán .
		int len1=s1.length()-1; // lấy độ dài chuỗi s1 tính từ 0
		int len2=s2.length()-1;// lấy độ dài chuỗi s2 tính từ 0

		//tìm độ dài lớn nhât của 2 chuỗi để chạy vòng lặp
		if(len1>=len2) {
			maxLen=len1;
		}
		else {
			maxLen=len2;
		}
			
		int tmp=0; //biến tạm lưu chữ số hàng chục của kết quả phép cộng lớn hơn 9

		//chạy vòng lặp để lấy giá trị từ dưới lên của mỗi chuỗi
		while(maxLen>=0) {
			String sum=""; // biến lưu kết quả phép cộng 2 số

			/*Điều kiện nếu như cả 2 độ dài 2 chuỗi chưa bé hơn 0 tức là 1 trong 2 chuỗi chưa hết số lượng
			 * giá trị thì cộng 2 sô đó cùng với biến tam.
			 * Nếu 1 trong 2 độ dài chuỗi bé hơn 0 tức là đã hết chuỗi giá trị
			 * thì chỉ lấy giá trị thứ 0 ( giá trị đầu tiên của chuỗi) và công với biến tạm
			 * Nếu cả 2 độ dài chuỗi đều bé hơn 0 mà biến tạm vẫn còn thì lấy sum bằng với biến tạm*/
			if(len1>=0 && len2>=0) {
				sum=((s1.charAt(len1)-'0')+(s2.charAt(len2)-'0')+tmp)+"";
			}else if(len1==-1 && len2>=0) {
				sum=(s2.charAt(len2)-'0'+tmp)+"";
			}else if(len1>=0 && len2==-1){
				sum=(s1.charAt(len1)-'0'+tmp)+"";
			}else{
				sum=tmp+"";
			}

			/*Điều kiện:
			 *  Nếu chuỗi sum có 2 số thì lấy giá trị hàng chục lưu vào biến tạm
			 * còn giá trị hàng đơn vị thì cộng vào chuỗi strSum
			 *  Nếu chuỗi sum chỉ có 1 số thì lấy giá trị đó cộng vào chuỗi strSum
			 *  còn giá trị biến tạm gán lại bằng 0*/
			if(sum.length()==2) {
				strSum =sum.charAt(1)+""+strSum;
				tmp=sum.charAt(0)-'0';
			}else {
				strSum =sum.charAt(0)+""+strSum;
				tmp=0;
			}
			/*Giảm độ dài các biến để chạy vòng lặp và để lấy giá trị kế tiếp của chuỗi.
			 * Kiểm tra nếu đã chạy hêt maxLen mà biến tmp vẫn có giá trị khác không
			 * thì không trừ maxLen để dừng vòng lặp mà cho tiếp tục chạy để cộng biến tạm đó vào chuỗi kết quả*/			
			if(maxLen==0) {
				if(tmp==0)
					maxLen--;
			}else
				maxLen--;
			len1--;
			len2--;
		}
		return strSum;
	}
}