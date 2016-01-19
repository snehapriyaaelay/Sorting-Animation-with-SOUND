package SortingAlgorithm;

public class StaticSortDisplayFactory implements SortDisplayFactory {

	@Override
	public SortDisplay makeSortDisplay(String name) {
		// TODO Auto-generated method stub
		if("horizontal".equals(name))
			return new HSortDisplay();
		else if("vertical".equals(name))
			return new VSortDisplay();
		else if("bottom".equals(name))
			return new BSortDisplay();
		else if("bar".equals(name))
			return new BarSortDisplay();
		else
		return new HSortDisplay();
	}

}
