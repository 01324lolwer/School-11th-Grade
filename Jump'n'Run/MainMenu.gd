extends MarginContainer

##Spielen Knopf
func _on_Button_pressed():
	get_tree().change_scene("res://Jump'n'Run.tscn")

##Schließen des Spieles
func _on_Button2_pressed():
	get_tree().quit()
