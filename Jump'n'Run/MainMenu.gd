extends MarginContainer

func _on_Button_pressed():
	get_tree().change_scene("res://Jump'n'Run.tscn")

func _on_Button2_pressed():
	get_tree().quit()
