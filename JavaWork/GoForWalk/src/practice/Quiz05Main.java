package practice;

import java.util.Date;

class TicketReservation {

	Date date = new Date();

	private static int uid;

	private int movieId;

	private int seatId;

	private Date regDate;

	public TicketReservation() {
		super();
	}

	public TicketReservation(int movieId, int seatId, Date regDate) {
		super();
		this.movieId = movieId;
		this.seatId = seatId;
		this.regDate = regDate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static int getUid() {
		return uid;
	}

	public static void setUid(int uid) {
		TicketReservation.uid = uid;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}