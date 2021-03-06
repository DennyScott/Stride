
<!doctype html>
<head>
<meta charset="utf-8" />
<title>Sonic</title>

<link href="css/styles.css" rel="Stylesheet" type="text/css" />
</head>
<body>

<script src="javascript/sonic.js"></script>
<div id="in"></div>

<script>

var circle = new Sonic({

   width: 100,
		height: 100,

		stepsPerFrame: 4,
		trailLength: 1,
		pointDistance: .01,
		fps: 25,
                
		fillColor: '#FF7B24',

		setup: function() {
			this._.lineWidth = 10;
		},

		step: function(point, i, f) {

			var progress = point.progress,
				degAngle = 360 * progress,
				angle = Math.PI/180 * degAngle,
				angleB = Math.PI/180 * (degAngle - 180),
				size = i*5;

			this._.fillRect(
				Math.cos(angle) * 25 + (50-size/2),
				Math.sin(angle) * 15 + (50-size/2),
				size,
				size
			);

			this._.fillStyle = '#63D3FF';

			this._.fillRect(
				Math.cos(angleB) * 15 + (50-size/2),
				Math.sin(angleB) * 25 + (50-size/2),
				size,
				size
			);

			if (point.progress == 1) {

				this._.globalAlpha = f < .5 ? 1-f : f;

				this._.fillStyle = '#EEE';

				this._.beginPath();
				this._.arc(50, 50, 5, 0, 360, 0);
				this._.closePath();
				this._.fill();

			}


		},

		path: [
			['line', 40, 10, 60, 90]
		]
	});

var d, a, container = document.getElementById('in');



	
	d = document.createElement('div');
	d.className = 'l';

	a = circle;

	d.appendChild(a.canvas);
	container.appendChild(d);

	a.canvas.style.marginTop = (150 - a.fullHeight) / 2 + 'px';
	a.canvas.style.marginLeft = (150 - a.fullWidth) / 2 + 'px';

	a.play();




</script> 
</body>
