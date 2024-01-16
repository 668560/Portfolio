package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminReviewAction {
	private Boolean accept;
	

	public AdminReviewAction(Boolean accept) {
		super();
		this.accept = accept;
	}

	public Boolean getAccept() {
		return accept;
	}

	public void setAccept(Boolean accept) {
		this.accept = accept;
	}
	
}
