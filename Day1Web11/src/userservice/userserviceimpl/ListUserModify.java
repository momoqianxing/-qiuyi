package userservice.userserviceimpl;

public class ListUserModify {
    private String userid;   //�û���
	private String password; //����
	
	private String city;     //����
	private String province; //ʡ
	private String country;  //��
	
	private String street1;  //��ϵ��ַ1
	private String street2;  //��ϵ��ַ2

	private String zip;      //�ʱ�
	
	private String  homephone; //��ͥ�绰
	private String  cellphone; //�ֻ��绰
	private String  officephone; //�칫�ҵ绰
	
	private String email;    //Email
	
	//�û���
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
    //����
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//����
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	//ʡ
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	//��
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	//��ϵ��ַ1
	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	//��ϵ��ַ2
	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	
	//�ʱ�
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	//��ͥ�绰
	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	
	//�ֻ�
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	//�칫�ҵ绰
	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}
 
	//E-mail
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
