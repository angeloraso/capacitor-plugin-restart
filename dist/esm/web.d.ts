import { WebPlugin } from '@capacitor/core';
import type { RestartPlugin } from './definitions';
export declare class RestartWeb extends WebPlugin implements RestartPlugin {
    enable(): Promise<void>;
    disable(): Promise<void>;
}
