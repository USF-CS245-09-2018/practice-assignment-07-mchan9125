public class ArrayList implements List{
	private Object[] array;
	private int size;

	public ArrayList(){
		array = new Object[10];
		size = 0;
	}
	@Override
	public void add(Object obj) {
		if(size == array.length) {
			growArr();
		}
		array[size] = obj;
		++size;
	}

	private void growArr(){
		Object[] newArr = new Object[array.length*2];
		for(int i = 0; i < array.length; i++) {
			newArr[i] = array[i];
		}
		array = newArr;
	}

	@Override
	public void add(int pos, Object obj) {
		if(pos >= 0 && pos <= size) {
			if(size + 1 >= array.length) {
				growArr();
			}
			for(int i = size; i > pos; i--) {
				array[i] = array[i-1];
			}
			array[pos] = obj;
			size++;
		}
	}

	@Override
	public Object get(int pos) {
		if(pos < 0 && pos >= size) {
			return null;
		}
		return array[pos];
	}

	@Override
	public Object remove(int pos) {
		if(pos < 0 && pos > size) {
			return null;
		}
		Object obj = array[pos];
		for(int i = pos; i < size -1; i++) {
			array[i] = array[i+1];
		}
		size--;
		return obj;
	}

	@Override
	public int size() {
		return size;
	}

}
