package mn.infosystems.callcenter.model;

import java.util.List;

public class Row
{
	private List<Cell> cellList;
	
	public Row()
    {
    }
    public Row(List<Cell> cellList)
    {
        this.cellList = cellList;
    }
    public Row(Row row)
    {
        this.cellList = row.getCellList();
    }

    public List<Cell> getCellList()
    {
        return cellList;
    }
    public void setCellList(List<Cell> cellList)
    {
        this.cellList = cellList;
    }
    public String findCell(String name){
    	for(Cell cell:cellList){
    		if(cell.getColumn().equals(name)){
    			return cell.getValue();
    		}
    	}
    	return "";
    }
}