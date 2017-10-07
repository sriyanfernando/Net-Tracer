<?php
	
	class ReportGen{

		echo 'Welcome to the Daily Report Generator'.<br>;
		echo "This generates full details of your net usage";

		excec(mkdir Stored_Reports);
		excec(sh Shell_Scripts/initiate.sh);

	}
	
?>
