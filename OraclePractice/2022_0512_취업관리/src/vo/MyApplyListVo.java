package vo;

public class MyApplyListVo {
	
	protected int apply_no;
	protected String com_name;
	protected String com_cat; //카테고리 따로 빼야할 것 같다...
	protected String com_focus;
	protected String rec_name;
	protected String rec_link;
	protected String apply_state;
	
	//getter/setter
	public int getApply_no() {
		return apply_no;
	}
	public void setApply_no(int apply_no) {
		this.apply_no = apply_no;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_cat() {
		return com_cat;
	}
	public void setCom_cat(String com_cat) {
		this.com_cat = com_cat;
	}
	public String getCom_focus() {
		return com_focus;
	}
	public void setCom_focus(String com_focus) {
		this.com_focus = com_focus;
	}
	public String getRec_name() {
		return rec_name;
	}
	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}
	public String getRec_link() {
		return rec_link;
	}
	public void setRec_link(String rec_link) {
		this.rec_link = rec_link;
	}
	public String getApply_state() {
		return apply_state;
	}
	public void setApply_state(String apply_state) {
		this.apply_state = apply_state;
	}
	
	
}
