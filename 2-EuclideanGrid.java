/**
 * A 2D grid implemented as an array.
 * Each (x,y) coordinate can hold a single item of type <T>.
 *
 * @param <T> The type of element held in the data structure
 */
public class ArrayGrid<T> implements Grid<T> {
	//The defined width of a grid, representing the sum of x-coordinate lengths
	private Integer width;
	//The defined height of a grid, representing the sum of y-coordinate lengths
	private Integer height;
	//A 2-dimensional array in rows and columns that can take in
	private T [][] twodarray;

	/**
	 * Constructs a new ArrayGrid object with a given width and height.
	 *
	 * @param width The width of the grid
	 * @param height The height of the grid
	 * @throws IllegalArgumentException If the width or height is less than
	 * or equal to zero
	 */
	public ArrayGrid(int width, int height) throws IllegalArgumentException {

		// TODO: implement the constructor
		if (height <= 0 || width <= 0)
		{
			throw new IllegalArgumentException("Parameter cannot be less " +
					"than zero");
		}
		this.width = width;
		this.height = height;
		twodarray = (T[][]) new Object[height][width];
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				twodarray[i][j] = null;
			}
		}
	}

	/**
	 * Add an element at a fixed position, overriding any existing
	 * element there.
	 *
	 * @param x       The x-coordinate of the element's position
	 * @param y       The y-coordinate of the element's position
	 * @param element The element to be added at the indicated position
	 * @throws IllegalArgumentException If the x or y value is out of the
	 * grid's maximum bounds
	 */

	@Override
	public void add(int x, int y, T element) throws IllegalArgumentException {

		if ( y > height || x > width)
		{
			throw new IllegalArgumentException("Index outside 2d array size");
		}
		twodarray[y][x] = element;
	}

	/**
	 * Returns the element at the indicated position.
	 *
	 * @param x The x-coordinate of the element to retrieve
	 * @param y The y-coordinate of the element to retrieve
	 * @return The element at this position, or null is no elements exist
	 * @throws IndexOutOfBoundsException If the x or y value is out of the
	 * grid's maximum bounds
	 */

	@Override
	public T get(int x, int y) throws IndexOutOfBoundsException {

		if ( y > height || x > width)
		{
			throw new IllegalArgumentException("Index outside 2d array size");
		}

		return twodarray[y][x];
	}

	/**
	 * Removes the element at the indicated position.
	 *
	 * @param x The x-coordinate of the element to remove
	 * @param y The y-coordinate of the element to remove
	 * @return true if an element was successfully removed, false if no
	 * element exists at (x, y)
	 * @throws IndexOutOfBoundsException If the x or y value is out of the
	 * grid's maximum bounds
	 */
	@Override
	public boolean remove(int x, int y) throws IndexOutOfBoundsException {

		if ( y > height || x > width)
		{
			throw new IllegalArgumentException("Index exceed 2d array bounds");
		}
		if (twodarray[y][x] == null)
		{
			return false;
		}
		else
		{
			twodarray[y][x] = null;
			return true;
		}
	}

	/**
	 * Removes all elements stored in the grid.
	 */
	@Override
	public void clear() {

		for (int i=0; i < height;i++)
		{
			for (int j=0; j < width;j++)
			{
				twodarray[i][j] = null;
			}
		}
	}

	/**
	 * Changes the size of the grid.
	 * Existing elements should remain at the same (x, y) coordinate
	 * If a resizing operation has invalid dimensions or causes an element
	 * to be lost,
	 * the grid should remain unmodified and an IllegalArgumentException
	 * thrown
	 *
	 * @param newWidth  The width of the grid after resizing
	 * @param newHeight The height of the grid after resizing
	 * @throws IllegalArgumentException if the width or height is less than
	 * or equal to zero, or if an element would be lost after this
	 * resizing operation
	 */
	@Override
	public void resize(int newWidth, int newHeight) throws
			IllegalArgumentException {

		if (width < 0 || height < 0)
		{
			throw new IllegalArgumentException("Index violate 2d array bounds");
		}
		for (int i = newHeight; i < height; i++)
		{
			for (int j = newWidth; j < width; j++)
			{
				if (twodarray[i][j] != null)
				{
					throw new IllegalArgumentException("You'll lose data!!");
				}
			}
		}
		//Array for temporary storage
		T[][] tempArray = (T[][]) new Object[newHeight][newWidth];
		for (int i = 0; i < newHeight && i < height;i++)
		{
			for (int j=0; j < newWidth && j < width;j++)
			{
				tempArray[i][j] = twodarray[i][j];
			}
		}
		this.width = newWidth;
		this.height = newHeight;
		twodarray = (T[][]) new Object[newHeight][newWidth];
		for (int i = 0; i < newHeight; i++)
		{
			for (int j = 0; j < newWidth; j++)
			{
				twodarray[i][j] = tempArray[i][j];
			}
		}
	}
}