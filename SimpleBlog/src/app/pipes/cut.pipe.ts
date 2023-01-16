import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cut'
})
export class CutPipe implements PipeTransform {

  transform(value: String,arg: number):String {
  
    return value.length>arg? value.substring(0,arg)+"...":value ;
  }

}
