import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjModel {

	public List<Vertex3f> getVertices() {
		return vertices;
	}

	public List<Vertex3f> getTextureCoordinates() {
		return textureCoordinates;
	}

	public List<Face> getFaces() {
		return faces;
	}

	private List<Vertex3f> vertices;
	private List<Vertex3f> textureCoordinates;
	private List<Face> faces;

	public ObjModel(File file) throws FileNotFoundException {

		vertices = new ArrayList<>();
		textureCoordinates = new ArrayList<>();
		faces = new ArrayList<>();

		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split(" ");
			if (line[0].equals("v")) {
				float x = Float.parseFloat(line[1]);
				float y = Float.parseFloat(line[2]);
				float z = Float.parseFloat(line[3]);
				vertices.add(new Vertex3f(x, y, z));
			} else if (line[0].equals("vt")) {
				float x = Float.parseFloat(line[1]);
				float y = Float.parseFloat(line[2]);
				textureCoordinates.add(new Vertex3f(x, y));
			} else if (line[0].equals("f")) {
				Face face = new Face();
				for (int i = 1; i < line.length; i++) {
					String[] sections = line[i].split("/");
					if (sections.length >= 1) {
						int vertex = Integer.parseInt(sections[0]);
						face.addVertex(vertex);
					}
					if (sections.length >= 2) {
						int textureCoordinate = Integer.parseInt(sections[1]);
						face.addTextureCoordinate(textureCoordinate);
					}
				}
				faces.add(face);
			}
		}

		scanner.close();
	}
}
