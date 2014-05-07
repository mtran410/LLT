<?php

		$con = mysql_connect("localhost","jqbao_lltuser","ITQ;6H7RDmeZ");
		if (!$con)
		  {
		  die('Could not connect: ' . mysql_error());
		  }
		mysql_select_db("jqbao_llt", $con);
		mysql_query("INSERT INTO game (name, type, creator_id) VALUES ('".$_REQUEST['name']."','".$_REQUEST['type']."','".$_REQUEST['id']."')");
		
		$result = mysql_query("SELECT  * FROM game WHERE name = '".$_REQUEST['name']."' AND type = '".$_REQUEST['type']."'AND creator_id = '".$_REQUEST['id']."'");

		
		while($data = mysql_fetch_array($result)) {
 				$output[] = $data;
			}
			if(is_null($output)){
					$post_data = json_encode(array('gamecreated' => 'false'), JSON_FORCE_OBJECT);
			
			}else{
				$post_data = json_encode(array('gamecreated' => 'true'), JSON_FORCE_OBJECT);
			
			}
					echo $post_data;
		
		  mysql_close($con);
		  
		  
?>