package mn.threesor.wms.enums;

public enum MeasuringUnit {
	 	choose  (-1l,""),
		count 	(0l,"ширхэг"),
		mass_kg	(1l,"килограмм"),
		mass_gr		(2l,"грамм"), 
		vol_l		(3l,"литр");
		
		private Long id;
		private String label;
		private MeasuringUnit(Long id , String label){
			this.id = id;
			this.label = label;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}

}
