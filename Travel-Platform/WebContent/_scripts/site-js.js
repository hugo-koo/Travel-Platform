/**
 * 
 */
window.onload = function() {
	console.log("TP");
//	var siteInit = function() {
//		ContextualMenu();
//		TextField();
//		Dropdown();
//		DatePicker();
//		Table();
//		Panel();
//	}
//	var ContextualMenu = function() {
		var ButtonElement = document
				.querySelector(".ms-ContextualMenu-basic .ms-Button");
		var ContextualMenuElement = document
				.querySelector(".ms-ContextualMenu-basic .ms-ContextualMenu");
		var contextualMenu = new fabric['ContextualMenu'](
				ContextualMenuElement, ButtonElement);
//	}
//	var TextField = function() {
		var TextFieldElements = document.querySelectorAll(".ms-TextField");
		for (var i = 0; i < TextFieldElements.length; i++) {
			new fabric['TextField'](TextFieldElements[i]);
		}
//	}
//	var Dropdown = function() {
		var DropdownHTMLElements = document.querySelectorAll('.ms-Dropdown');
		for (var i = 0; i < DropdownHTMLElements.length; ++i) {
			var Dropdown = new fabric['Dropdown'](DropdownHTMLElements[i]);
		}
//	}
//	var DatePicker = function() {
		var DatePickerElements = document.querySelectorAll(".ms-DatePicker");
		for (var i = 0; i < DatePickerElements.length; i++) {
			new fabric['DatePicker'](DatePickerElements[i]);
		}
//	}
//	var Table = function() {
		var TableElements = document.querySelectorAll(".ms-Table");
		for (var i = 0; i < TableElements.length; i++) {
			new fabric['Table'](TableElements[i]);
		}
//	}
//	var Panel = function() {
		var PanelExamples = document.getElementsByClassName("ms-PanelExample");
		for (var i = 0; i < PanelExamples.length; i++) {
			(function() {
				var PanelExampleButton = PanelExamples[i]
						.querySelector(".ms-Button");
				var PanelExamplePanel = PanelExamples[i]
						.querySelector(".ms-Panel");
				PanelExampleButton.addEventListener("click", function(i) {
					new fabric['Panel'](PanelExamplePanel);
				});
			}());
		}
//	}
}