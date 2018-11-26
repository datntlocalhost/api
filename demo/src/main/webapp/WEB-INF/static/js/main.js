var context = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function() {
	clickClassEvent();
	clickMethodEvent();
	formTestSubmit();
	searchMethodEvent();
	updateEvent();
});

$.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = [this.value];
            }
        });
        return o;
};




/*
 * To render method list when click on class.
 */
function renderMethodList(data, flag) {
	
	if (data != null) {
		
		if (flag) {
			$("#class").text(data.clazz);
			$("#method").text("");
			$(".js-methods").remove();
			$("#js-dst-content").text(data.description);
		}
		
		let methods = data.methods;
		
		for (let i in methods) {
			let methodName = methods[i].methodName;
			let signature  = methods[i].signature;
			let href = '/method?class=' + data.clazz + '&method=' + methodName + '&signature=' + signature;
			let liTag = $('<li />', {class: 'js-methods'});
			let aTag = $('<a />', {class: 'js-click-method', text: methodName, href: href, value: data.clazz});
			$("#js-list-method").append(liTag.append(aTag));
		}
		clickMethodEvent();
	}
}

/*
 * To render list of method after search.
 */
function renderSearchMethod(data) {
	if (data != null) {
	
		$("#js-unit-test").hide();
		$("#js-description").hide();
		$("#class").text("");
		$("#method").text("");
		$(".js-methods").remove();
		
		for (let i in data) {
			let clazz = data[i];
			renderMethodList(clazz, false);
		}
		
	}
}

/*
 * To render method description and form to input parameter.
 */
function renderMethodInfo(data) {
	if (data != null) {
		$("#method").text(data.methodName);
		$("#js-dst-content").text(data.description);
		$(".input-txt").remove();
		
		let params = data.parameterModels;
		let param   = '';
		
		for (let i in params) {
			
			let nameParam = params[i].nameParameter;
			
			param += nameParam + ' (' + params[i].typeParameter + ') - ' + params[i].description + '<br>';
			
			$("#js-input-frm").append(
				$('<div />', {class: 'form-group input-txt'}).append(
					$('<label />', {for: nameParam, class: 'col-sm-2 control-label', text: nameParam}),
					$('<div />', {class: 'col-sm-10'}).append(
						$('<input />', {type: 'text', class: 'form-control', name: 'parameters', placeholder: params[i].description})
					)
				)
			);
		}
		
		$("#js-dst-param").append(param);
		$("#js-dst-return").append(data.returns);
	}
}

/*
 * Process event when click on class
 */
function clickClassEvent() {
	$(".js-click-class").on('click', function(event) {
		
		$("#js-unit-test").hide();
		$("#js-description").show();
		$("#js-dst-detail").hide();
		
		let className = $(this).text();
		
		$.ajax({
			type: 'get',
			contentType: 'application/json',
			dataType: 'json',
			url: context + '/class?class=' + className,
			data: '',
			success : function(data) {
				$("#class").text(className);
				renderMethodList(data, true);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		event.preventDefault();
	});
}

/*
 * Process event when click on method
 */
function clickMethodEvent() {
	$(".js-click-method").on('click', function(event) {
		let href = $(this).attr('href');
		resetDescriptionDetail();
		resetResultTest();
		
		$("#class").text($(this).attr('value'));
		$("#js-description").show();
		$("#js-unit-test").show();
		$("#js-dst-detail").show();
		
		$.ajax({
			type: 'get',
			contentType: 'application/json',
			dataType: 'json',
			url: context + href,
			data: '',
			success : function(data) {
				renderMethodInfo(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		
		event.preventDefault();
	});
}

function formTestSubmit() {
	$("#js-test-frm").on('submit', function(event) {
		resetResultTest();
		$.ajax({
			type: 'post',
			contentType: 'application/json',
			dataType: 'json',
			url: context + '/checkvalid',
			data: JSON.stringify($(this).serializeObject()),
			success : function(data) {
				if (data != null) {
					if (data.error) {
						$("#js-exception").val(data.errorMsg);
					} else {
						$("#js-return").val(data.result);
					}
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		
		event.preventDefault();
	});
}

function searchMethodEvent() {
	$("#js-search-frm").on('submit', function(event) {
		
		let param = $("#js-search-frm input[name='method']").val();

		$.ajax({
			type: 'get',
			contentType: 'application/json',
			dataType: 'json',
			url: context + '/search?method=' + param,
			data: '',
			success : function(data) {
				renderSearchMethod(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		
		event.preventDefault();
	});
}

function updateEvent() {
	$("#js-update").on('click', function(event) {
		
		$.ajax({
			type: 'get',
			contentType: 'application/json',
			dataType: 'json',
			url: context + '/update',
			data: '',
			success : function(data) {
				location.reload();
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		
		event.preventDefault();
	});
}

function resetDescriptionDetail() {
	$("#js-dst-param").text("");
	$("#js-dst-return").text("");
}

function resetResultTest() {
	$("#js-return").val("");
	$("#js-exception").val("");
}