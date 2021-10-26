import { WebPlugin } from '@capacitor/core';

import type { RestartPlugin } from './definitions';

export class RestartWeb extends WebPlugin implements RestartPlugin {
  async enable(): Promise<void>{
    throw this.unimplemented('Not implemented on web.');
  }
  async disable(): Promise<void>{
    throw this.unimplemented('Not implemented on web.');
  }
}
