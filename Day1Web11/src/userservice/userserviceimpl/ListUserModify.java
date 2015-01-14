package userservice.userserviceimpl;

public class ListUserModify {
    private String userid;   //用户名
	private String password; //密码
	
	private String city;     //国家
	private String province; //省
	private String country;  //市
	
	private String street1;  //联系地址1
	private String street2;  //联系地址2

	private String zip;      //邮编
	
	private String  homephone; //家庭电话
	private String  cellphone; //手机电话
	private String  officephone; //办公室电话
	
	private String email;    //Email
	
	//用户名
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
    //密码
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//国家
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	//省
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	//市
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	//联系地址1
	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	//联系地址2
	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	
	//邮编
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	//家庭电话
	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	
	//手机
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	//办公室电话
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
