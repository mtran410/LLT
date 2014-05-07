<?php

		$con = mysql_connect("localhost","jqbao_lltuser","ITQ;6H7RDmeZ");
		if (!$con)
		  {
		  die('Could not connect: ' . mysql_error());
		  }
		mysql_select_db("jqbao_llt", $con);
		mysql_query("INSERT INTO `players_in_game`( `pid`, `gid`) VALUES ('".$_REQUEST['pid']."','".$_REQUEST['gid']."')");
		
		$result = mysql_query("SELECT  * FROM players_in_game WHERE pid = '".$_REQUEST['pid']."' AND gid = '".$_REQUEST['gid']."'");

		
		while($data = mysql_fetch_array($result)) {
 				$output[] = $data;
			}
			if(is_null($output)){
					$post_data = json_encode(array('joinedgamesuccess' => 'false'), JSON_FORCE_OBJECT);
			
			}else{
				$post_data = json_encode(array('joinedgamesuccess' => 'true'), JSON_FORCE_OBJECT);
			
			}
					echo $post_data;
		
		  mysql_close($con);
		  
		  
?>