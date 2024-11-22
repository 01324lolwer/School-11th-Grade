extends Node2D

##Drücken von "ESC" bringt zum Menü
func _input(event):
	if Input.is_action_just_pressed("Menu"):
		print("aa")
		if not get_tree().paused:
			print("bb")
			get_tree().paused = true
		else:
			print("dd")
			get_tree().paused = false
