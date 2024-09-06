extends MarginContainer

##Spielen Knopf
func _on_Button_pressed():
	get_tree().change_scene("res://Tutorial.tscn")

##Schließen des Spieles
func _on_Button2_pressed():
	get_tree().quit()

##Level Manager
func _on_Levels_pressed():
	get_tree().change_scene("res://LevelMenu.tscn")
