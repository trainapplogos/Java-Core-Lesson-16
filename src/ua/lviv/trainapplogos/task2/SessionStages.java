package ua.lviv.trainapplogos.task2;

public interface SessionStages {
	public int SessionStart(int yearOfStudy);
	public int SessionEnd(int yearOfStudy);
	public void BreakSession();
}
