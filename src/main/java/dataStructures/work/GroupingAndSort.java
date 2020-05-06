package dataStructures.work;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Author hike97
 * @Description
 * @create 2020-03-17 16:49
 * @Modified By:
 **/
public class GroupingAndSort {
	public static void main(String[] args) {
		List<GroupDetailDTO> list = new ArrayList<> ();
		GroupDetailDTO dto1 = new GroupDetailDTO();
		dto1.setHeadsetId(1);
		dto1.setTime("2020-01-03");
		dto1.setActConcreteTime("a");
		dto1.setPlayed(1);
		list.add(dto1);

		GroupDetailDTO dto2 = new GroupDetailDTO();
		dto2.setHeadsetId(1);
		dto2.setTime("2020-01-01");
		dto2.setActConcreteTime("b");
		dto2.setPlayed(1);
		list.add(dto2);

		GroupDetailDTO dto3 = new GroupDetailDTO();
		dto3.setHeadsetId(1);
		dto3.setTime("2020-01-02");
		dto3.setActConcreteTime("c");
		dto3.setPlayed(1);
		list.add(dto3);

		GroupDetailDTO dto4 = new GroupDetailDTO();
		dto4.setHeadsetId(2);
		dto4.setTime("2020-01-01");
		dto4.setActConcreteTime("d");
		dto4.setPlayed(4);
		list.add(dto4);

		Map<GroupDetailDTO, Integer> collect = list.stream().
				collect(Collectors.groupingBy(o -> new GroupDetailDTO(o.getHeadsetId(), o.getTime()),
						TreeMap::new, Collectors.summingInt(o -> o.getPlayed())));
		collect.forEach((k, v) -> {
			System.out.println(k + "@@@" + v);
		});
	}

}

@Data
class GroupDetailDTO implements Comparable<GroupDetailDTO> {
	private Integer headsetId;
	private String actConcreteTime;
	private String time;
	private Integer played;

	public GroupDetailDTO() {
	}

	public GroupDetailDTO(Integer headsetId, String time) {
		this.headsetId = headsetId;
		this.time = time;
	}

	@Override
	public int compareTo(GroupDetailDTO o) {
		String a = this.headsetId + "|" + this.getTime();
		String b = o.getHeadsetId() + "|" + o.getTime();
		return a.compareTo(b);
		//    return this.getTime().compareTo(o.gtTime());
	}
}


