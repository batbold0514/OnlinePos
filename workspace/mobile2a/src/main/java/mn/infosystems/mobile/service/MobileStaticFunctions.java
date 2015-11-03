package mn.infosystems.mobile.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mn.infosystems.mobile.model.Messages;
import mn.infosystems.mobile.model.SubGroup;
import mn.infosystems.mobile.model.TeachingAid;

public class MobileStaticFunctions {

	public static int level = 0;
	public static int KeepingAndCredit = 0;
	public static String dateToStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public static Date strToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static String convertTree(List<SubGroup> list){
		String str = "";
		for(SubGroup sg:list){
			str+=
					"<div class=\"tree-folder\" style=\"display: block;\">"
							+"<div class=\"tree-folder-header\">"+
								"<i class=\"fa fa-folder\"></i>"+
									"<div class=\"tree-folder-name\">"
										+sg.getGroupName()+"" +
										"<div class=\"tree-actions\">"+
											"<i class=\"fa fa-plus\" onclick=\"addSubGroup("+sg.getId()+")\" style=\"background-color: #5cb85c;\" title=\'"
												+Messages.getString("addSubGroup", "mobile_mn")+"\' ></i>"+
											"<i class=\"fa fa-plus\"  onclick=\"addTeachingAid("+sg.getId()+")\" style=\"background-color: #39b3d7;\" title=\'" 
												+Messages.getString("addTeachingAid", "mobile_mn")+"\'></i>"+
											"<i class=\"fa fa-edit\" onclick=\"editSubGroup("+sg.getId()+")\" style=\"background-color: #f0ad4e;\" title=\'"
												+Messages.getString("editSubGroup", "mobile_mn")+"\' ></i>"+
											"<i class=\"fa fa-trash-o\"  onclick=\"removeSubGroup("+sg.getId()+")\" style=\"background-color: #d9534f;\" title=\'" 
												+Messages.getString("removeSubGroup", "mobile_mn")+"\'></i>"+
											
										"</div>" +
									"</div>"+
							"</div>"+
							"<div class=\"tree-folder-content\">";
								if(!sg.getListOfSubGroup().isEmpty()){
									str +=convertTree(sg.getListOfSubGroup());
								}
							for(TeachingAid ta:sg.getListOfTeachingAid()){
								str+="<div class=\"tree-item\" style=\"display: block;\">"
										+"<i class=\"tree-dot\"></i>"
										+"<div class=\"tree-item-name\">"
											+"<i class=\"fa fa-file-text-o\"></i>"+ta.getName()
											+"<div class=\"tree-actions\">"
												+"<i class=\"fa fa-edit\" onclick=\"editTeachingAid("+ta.getId()+")\" style=\"background-color: #f0ad4e;\" title=\'" 
													+Messages.getString("editTeachingAid", "mobile_mn")+"\' ></i>"
												+"<i class=\"fa fa-trash-o\" onclick=\"removeTeachingAid("+sg.getId()+","+ta.getId()+")\" style=\"background-color: #d9534f;\" title=\'" 
														+Messages.getString("removeTeachingAid", "mobile_mn")+"\' ></i>"
											+"</div>"
										+"</div>"
									+"</div>";
							}
							str+="</div>"+
						"</div>";
			
		}
		return str;
	}
	
	
}
