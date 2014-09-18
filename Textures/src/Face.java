import java.util.ArrayList;
import java.util.List;

public class Face {

	public Face() {
		vertices = new ArrayList<>();
		textureCoordinates = new ArrayList<>();
	}

	public List<Integer> getVertices() {
		return vertices;
	}

	public List<Integer> getTextureCoordinates() {
		return textureCoordinates;
	}

	private List<Integer> vertices;
	private List<Integer> textureCoordinates;

	public void addVertex(int vertex) {
		vertices.add(vertex);
	}

	public void addTextureCoordinate(int textureCoordinate) {
		textureCoordinates.add(textureCoordinate);
	}
}
