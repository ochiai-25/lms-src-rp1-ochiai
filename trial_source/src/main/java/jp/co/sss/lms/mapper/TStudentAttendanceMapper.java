package jp.co.sss.lms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.sss.lms.dto.AttendanceManagementDto;
import jp.co.sss.lms.entity.TStudentAttendance;

/**
 * 勤怠情報（受講生入力）テーブルマッパー
 * 
 * @author 東京ITスクール
 */
@Mapper
public interface TStudentAttendanceMapper {

	/**
	 * 勤怠情報（受講生入力）取得（LMSユーザーID）
	 */
	List<TStudentAttendance> findByLmsUserId(@Param("lmsUserId") Integer lmsUserId,
			@Param("deleteFlg") Short deleteFlg);

	/**
	 * 勤怠情報（受講生入力）取得（LMSユーザーID＆日付）
	 */
	TStudentAttendance findByLmsUserIdAndTrainingDate(@Param("lmsUserId") Integer lmsUserId,
			@Param("trainingDate") Date trainingDate, @Param("deleteFlg") Short deleteFlg);

	/**
	 * 勤怠管理画面用DTOリスト取得
	 */
	List<AttendanceManagementDto> getAttendanceManagement(@Param("courseId") Integer courseId,
			@Param("lmsUserId") Integer lmsUserId, @Param("deleteFlg") Short deleteFlg);

	/**
	 * 過去日の勤怠未入力件数取得
	 *
	 * @param lmsUserId
	 * @param deleteFlg
	 * @param trainingDate
	 * @return 過去日の勤怠未入力件数
	 */
	Integer countPastUnenteredAttendance(
			@Param("lmsUserId") Integer lmsUserId,   /**誰の勤怠なのか*/
			@Param("deleteFlg") Short deleteFlg,	/**削除されているデータを除外*/
			@Param("trainingDate") Date trainingDate);  /**どの日付を基準にして過去日を判定するか指定＊/

	/**
	 * 勤怠情報（受講生入力）登録
	 */
	Boolean insert(TStudentAttendance tStudentAttendance);

	/**
	 * 勤怠情報（受講生入力）更新
	 */
	Boolean update(TStudentAttendance tStudentAttendance);

}
