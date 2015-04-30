package input;

import attackEng.MobType;

public class MobReaderClass extends ReaderClass{

	public MobReaderClass(String path) {
		super(path);
	}
	
	public String getName(int itemNumber) {
		return getData(itemNumber, 0);
	}
	
	public MobType getType(int itemNumber) {
		switch (Integer.parseInt(getData(itemNumber, 1))) {
		case 0:
			return MobType.Human	;
		case 1:
			return MobType.Zombie;
		case 2:
			return MobType.Alien;
		default:
			return MobType.none;

		}
	}
}
