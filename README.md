<h1 align="center">Interpolation Library</h1>

<p align="center">
Creating my first library for Processing that allows for non-linear interpolation based on my previous project <a href="https://github.com/yahirRendon/processing-snips/tree/main/custom-functions/interpolation">here</a>. 
</p>

## About
<p>
Processing has a method called lerp() for linear interpolation. A start value, end value and an amount between 0.0 and 1.0 are passed as parameters into the function and a value is returned. The value maps linearly between the start and end values and the defined amount. Another built in method is norm() which is essentially the inverse of lerp(). A start and end value are provided as parameters along with a value between the two. The method then returns a value between 0.0 and 1.0 that again maps linearly between the two. 
</p>
<p>
After coming across easing functions provided by <a href="easings.net">easings.net</a> I decided to create a Processing library that introduces non-linear interpolation along with corresponding inverse functions. This required converting the typescript examples into java methods that match the lerp() and norm() standard. However, <a href="easings.net">easings.net</a> doesn’t provide inverse functions so I had to brush up on my trigonometry to come up with the corresponding inverse functions. I’ve been able to convert several but would like to continue working on this and eventually create interpolation and inverse functions for all the easing functions listed at <a href="easings.net">easings.net</a>. 
</p>
<p>
To create the Processing Library I used the master library template provided here as a starting point. 
</p>

## Preview
<p>
Visual representation of linear versus non-linear interpolation can be seen below. These come from my initial work that can be seen <a href="https://github.com/yahirRendon/processing-snips/tree/main/custom-functions/interpolation">here</a> These functions can be manually added to a Processing project if you only need one or two of the methods. 
</p>
<p align="center">
  <img width="450" 
    align="center" 
    alt="sine interpolation"
    src="https://github.com/yahirRendon/processing-snips/blob/main/custom-functions/interpolation/interpolation-code/data/sine_interp_anim.gif"
    />
  <img width="450" 
    align="center" 
    alt="quad interpolation"
    src="https://github.com/yahirRendon/processing-snips/blob/main/custom-functions/interpolation/interpolation-code/data/quad_interp_anim.gif"
    /> 
</p>
<p align="center">
 <img width="450" 
    align="center" 
    alt="quad interpolation"
    src="https://github.com/yahirRendon/processing-snips/blob/main/custom-functions/interpolation/interpolation-code/data/expo_interp_anim.gif"
    />
</p>

## Documentation

<details>
  <summary>serp functions</summary>
  

| name              | parameter 1      | parameter 2      | parameter 3     |
| :---------------- | :--------------: | :--------------: |:--------------: |
| serpIn            |  (int) start     | (int) end        |(float) amount   |
| serpOut           |  (int) start     | (int) end        |(float) amount   |
| serpInOut         |  (int) start     | (int) end        |(float) amount   |

| name              | parameter 1      | parameter 2      | parameter 3     |
| :---------------- | :--------------: | :--------------: |:--------------: |
| serpInInverse     |  (int) start     | (int) end        |(float) value   |
| serpOutInverse    |  (int) start     | (int) end        |(float) value   |
| serpInOutInverse  |  (int) start     | (int) end        |(float) value   |

</details>

## Usage Notes
<p>- Processing 4.5.4^
</p>

